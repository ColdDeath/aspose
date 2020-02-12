package ru.gbuac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.gbuac.dao.DocAgreementRepository;
import ru.gbuac.dao.DocRepository;
import ru.gbuac.dao.UserRepository;
import ru.gbuac.model.DecisionType;
import ru.gbuac.model.Doc;
import ru.gbuac.model.DocAgreement;
import ru.gbuac.model.User;
import ru.gbuac.to.DocAgreementTo;
import ru.gbuac.util.DocAgreementUtil;
import ru.gbuac.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static ru.gbuac.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DocAgreementServiceImpl implements DocAgreementService {

    @Autowired
    DocAgreementRepository docAgreementRepository;

    @Autowired
    DocRepository docRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailService mailService;

    @Override
    public DocAgreement get(int id, int docId) throws NotFoundException {
        DocAgreement docAgreement = docAgreementRepository.findById(id).orElse(null);
        return checkNotFoundWithId(docAgreement != null && docAgreement.getDoc().getId() == docId ? docAgreement : null, id);
    }

    @Override
    public List<DocAgreementTo> getAgreementList(int docId) {
        return docAgreementRepository.getAgreementList(docId);
    }

    @Override
    public List<DocAgreement> getAll(int docId) {
        return docAgreementRepository.findAll();
    }

    @Override
    public DocAgreementTo save(DocAgreement docAgreement) {
        Assert.notNull(docAgreement, "docAgreement must not be null");
        return DocAgreementUtil.asTo(docAgreementRepository.save(docAgreement));
    }

    @Override
    public DocAgreementTo update(DocAgreement docAgreement, int id) throws NotFoundException {
        Assert.notNull(docAgreement, "docAgreement must not be null");
        return DocAgreementUtil.asTo(checkNotFoundWithId(docAgreementRepository.save(docAgreement),id));
    }

    @Override
    public List<DocAgreementTo> saveList(List<DocAgreement> agreementList, int docId) {
        Doc doc = docRepository.findById(docId).orElse(null);
        agreementList.sort(Comparator.comparing(DocAgreement::getOrdering));
        for (DocAgreement da: agreementList) {
            da.setDoc(doc);
            docAgreementRepository.save(da);
            if (da.getOrdering() == 1 && da.isCurrentUser()) {
                User user = userRepository.findById(da.getUser().getId()).orElse(null);
                mailService.sendAgreementEmail(Objects.requireNonNull(user).getEmail(), docId, Objects.requireNonNull(doc).getProjectRegNum());
            }
        }

        return docAgreementRepository.getAgreementList(docId);
    }

    @Override
    public List<DocAgreementTo> redirect(int docId, int targetUserId, String comment, String userName) {
        List<DocAgreementTo> agreementList = docAgreementRepository.getAgreementList(docId);
        agreementList.sort(Comparator.comparing(DocAgreementTo::getOrdering));
        User targetUser = userRepository.findById(targetUserId).orElse(null);
        User curUser = userRepository.getByName(userName);

        Integer curUserOrder = agreementList.stream().filter(DocAgreementTo::isCurrentUser)
                .map(DocAgreementTo::getOrdering).findFirst().orElse(null);
        DocAgreement curDa = docAgreementRepository.getByOrder(docId, curUserOrder);
        boolean isFinalUser = curDa.isFinalUser();
        curDa.setFinalUser(false);
        curDa.setCurrentUser(false);
        curDa.setDecisionType(DecisionType.REDIRECTED);
        curDa.setAgreedDateTime(LocalDateTime.now());
        curDa.setComment(comment);
        curDa.setReturnedUser(targetUser);
        docAgreementRepository.save(curDa);

        Doc doc = docRepository.findById(docId).orElse(null);
        DocAgreement redirectionDa = new DocAgreement(null, curUserOrder+1, doc, targetUser,
                null, null, null, null,
        false, true);
        docAgreementRepository.save(redirectionDa);

        DocAgreement continueCurUserDa = new DocAgreement(null, curUserOrder+2, doc, curUser,
                null, null, null, null, isFinalUser, false);
        docAgreementRepository.save(continueCurUserDa);

        List<DocAgreementTo> lastPartDa = agreementList.stream()
                .filter(a -> a.getOrdering() > curUserOrder).collect(Collectors.toList());
        for (DocAgreementTo daTo: lastPartDa) {
            DocAgreement da = docAgreementRepository.findById(daTo.getId()).orElse(null);
            da.setOrdering(Objects.requireNonNull(da).getOrdering()+2);
            docAgreementRepository.save(da);
        }

        return docAgreementRepository.getAgreementList(docId);
    }

    @Override
    public void delete(int id, int docId) throws NotFoundException {
        Assert.notNull(id, "docAgreement must not be null");
        checkNotFoundWithId(docAgreementRepository.delete(id, docId) != 0, id);
    }
}
