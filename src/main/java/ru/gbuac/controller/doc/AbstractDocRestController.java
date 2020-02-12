package ru.gbuac.controller.doc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import ru.gbuac.AuthorizedUser;
import ru.gbuac.model.Doc;
import ru.gbuac.model.User;
import ru.gbuac.service.DocService;
import ru.gbuac.to.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.gbuac.util.ValidationUtil.assureIdConsistent;
import static ru.gbuac.util.ValidationUtil.checkNew;

public abstract class AbstractDocRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    protected DocService docService;

    public Map<String, Integer> getCounters() {
        LOG.info("getCounters");
        String userName = AuthorizedUser.getUserName();
        Map<String, Integer> map = Stream.of(new Object[][] {
                { "agreement", AuthorizedUser.hasRole("ADMIN") ?
                        docService.getAllAgreement().size() : docService.getAllAgreementByUsername(userName).size() },
                { "agreementMoreDeadlineByUserName", docService.getAllAgreementMoreDeadlineByUserName(userName).size() },
                { "agreementLessDeadlineByUserName", docService.getAllAgreementLessDeadlineByUserName(userName).size() },

                { "inwork", docService.getAllInWorkByUserName(AuthorizedUser.getUserName()).size() },
                { "inworkMoreDeadlineByUserName", docService.getAllInWorkMoreDeadlineByUserName(userName).size() },
                { "inworkLessDeadlineByUserName", docService.getAllInWorkLessDeadlineByUserName(userName).size() },

                { "distribution", docService.getAllDistribution(userName).size() },
                { "distributionMoreDeadlineByChiefUserName", docService.getAllDistributionMoreDeadlineByChiefUserName(userName).size() },
                { "distributionLessDeadlineByChiefUserName", docService.getAllDistributionLessDeadlineByChiefUserName(userName).size() },

                { "atThisMounthOnControl", docService.getAllAtThisMounthOnControl(userName).size() },
                { "atThisMounthOnControlCompletedInTime", docService.getAllAtThisMounthOnControlCompletedInTime(userName).size() },
                { "atThisMounthOnControlCompletedAfterTime", docService.getAllAtThisMounthOnControlCompletedAfterTime(userName).size() },
                { "atThisMounthOnControlNotCompleted", docService.getAllAtThisMounthOnControlNotCompleted(userName).size() },

                { "agreementMoreDeadlineByDepartment", docService.getAllAgreementMoreDeadlineByDepartment(userName).size() },
                { "agreementLessDeadlineByDepartment", docService.getAllAgreementLessDeadlineByDepartment(userName).size() },
                { "inworkMoreDeadlineByDepartment", docService.getAllInWorkMoreDeadlineByDepartment(userName).size() },
                { "inworkLessDeadlineByDepartment", docService.getAllInWorkLessDeadlineByDepartment(userName).size() },
                { "distributionMoreDeadlineByDepartment", docService.getAllDistributionMoreDeadlineByDepartment(userName).size() },
                { "distributionLessDeadlineByDepartment", docService.getAllDistributionLessDeadlineByDepartment(userName).size() },
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        return map;
    }

    public List<Doc> getAllAgreementMoreDeadlineByUserName(HttpSession session) {
        LOG.info("getAllAgreementMoreDeadlineByUserName");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllAgreementMoreDeadlineByUserName(delegatedUser.getName());
        }
        return docService.getAllAgreementMoreDeadlineByUserName(AuthorizedUser.getUserName());
    }

    public List<Doc> getAllAgreementLessDeadlineByUserName(HttpSession session) {
        LOG.info("getAllAgreementLessDeadlineByUserName");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllAgreementLessDeadlineByUserName(delegatedUser.getName());
        }
        return docService.getAllAgreementLessDeadlineByUserName(AuthorizedUser.getUserName());
    }

    public List<Doc> getAllAgreementMoreDeadlineByDepartment(HttpSession session) {
        LOG.info("getAllAgreementMoreDeadlineByDepartment");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllAgreementMoreDeadlineByDepartment(delegatedUser.getName());
        }
        return docService.getAllAgreementMoreDeadlineByDepartment(AuthorizedUser.getUserName());
    }

    public List<Doc> getAllAgreementLessDeadlineByDepartment(HttpSession session) {
        LOG.info("getAllAgreementLessDeadlineByDepartment");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllAgreementLessDeadlineByDepartment(delegatedUser.getName());
        }
        return docService.getAllAgreementLessDeadlineByDepartment(AuthorizedUser.getUserName());
    }

    public Doc get(int id) {
        LOG.info("get " + id);
        return docService.get(id);
    }

    public DocTo getFull(int id, HttpSession session) {
        LOG.info("get " + id);
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if (delegatedUser != null) {
            return docService.getFullByUserName(id, delegatedUser.getName());
        }
        return docService.getFullByUserName(id, AuthorizedUser.getUserName());
    }

    public List<Doc> getAllAgreement(HttpSession session) {
        LOG.info("getAllAgreement");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        return AuthorizedUser.hasRole("ADMIN") ?
                docService.getAllAgreement() : docService.getAllAgreementByUsername(
                delegatedUser != null ? delegatedUser.getName() : AuthorizedUser.getUserName());
    }

    public List<Doc> getAllAgreed(HttpSession session) {
        LOG.info("getAllAgreed");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        return AuthorizedUser.hasRole("ADMIN") ?
                docService.getAllRegistered() : docService.getAllAgreedByUsername(
                        delegatedUser!= null ? delegatedUser.getName() : AuthorizedUser.getUserName());
    }

    public List<Doc> getAllRegistered(HttpSession session) {
        LOG.info("getAllRegistered");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        return AuthorizedUser.hasRole("ADMIN") ?
                docService.getAllRegistered() : docService.getAllRegisteredByUsername(
                        delegatedUser != null ? delegatedUser.getName() : AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllInWorkByUserName(HttpSession session) {
        LOG.info("getAllInWorkByUserName");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllInWorkByUserName(delegatedUser.getName());
        }
        return docService.getAllInWorkByUserName(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllInWorkMoreDeadlineByUserName(HttpSession session) {
        LOG.info("getAllInWorkMoreDeadlineByUserName");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllInWorkMoreDeadlineByUserName(delegatedUser.getName());
        }
        return docService.getAllInWorkMoreDeadlineByUserName(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllInWorkLessDeadlineByUserName(HttpSession session) {
        LOG.info("getAllInWorkLessDeadlineByUserName");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllInWorkLessDeadlineByUserName(delegatedUser.getName());
        } return docService.getAllInWorkLessDeadlineByUserName(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllInWorkMoreDeadlineByDepartment(HttpSession session) {
        LOG.info("getAllInWorkMoreDeadlineByDepartment");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllInWorkMoreDeadlineByDepartment(delegatedUser.getName());
        }
        return docService.getAllInWorkMoreDeadlineByDepartment(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllInWorkLessDeadlineByDepartment(HttpSession session) {
        LOG.info("getAllInWorkLessDeadlineByDepartment");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
           return docService.getAllInWorkLessDeadlineByDepartment(delegatedUser.getName());
        }
        return docService.getAllInWorkLessDeadlineByDepartment(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllDistribution(HttpSession session) {
        LOG.info("getAllDistribution");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllDistribution(delegatedUser.getName());
        }
        return docService.getAllDistribution(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllDistributionMoreDeadlineByChiefUserName(HttpSession session) {
        LOG.info("getAllDistributionMoreDeadlineByChiefUserName");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllDistributionMoreDeadlineByChiefUserName(delegatedUser.getName());
        }
        return docService.getAllDistributionMoreDeadlineByChiefUserName(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllDistributionLessDeadlineByChiefUserName(HttpSession session) {
        LOG.info("getAllDistributionLessDeadlineByChiefUserName");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllDistributionLessDeadlineByChiefUserName(delegatedUser.getName());
        }
        return docService.getAllDistributionLessDeadlineByChiefUserName(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllDistributionMoreDeadlineByDepartment(HttpSession session) {
        LOG.info("getAllDistributionMoreDeadlineByDepartment");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if (delegatedUser != null) {
            return docService.getAllDistributionMoreDeadlineByDepartment(delegatedUser.getName());
        }
        return docService.getAllDistributionMoreDeadlineByDepartment(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllDistributionLessDeadlineByDepartment(HttpSession session) {
        LOG.info("getAllDistributionLessDeadlineByDepartment");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if (delegatedUser != null) {
            return docService.getAllDistributionLessDeadlineByDepartment(delegatedUser.getName());
        }
        return docService.getAllDistributionLessDeadlineByDepartment(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllDistributed(HttpSession session) {
        LOG.info("getAllDistributed");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if (delegatedUser != null) {
            return docService.getAllDistributed(delegatedUser.getName());
        }
        return docService.getAllDistributed(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllAtThisMonthOnControl(HttpSession session) {
        LOG.info("getAllAtThisMonthOnControl");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if (delegatedUser != null) {
            return docService.getAllAtThisMounthOnControl(delegatedUser.getName());
        }
        return docService.getAllAtThisMounthOnControl(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllAtThisMonthOnControlCompletedInTime(HttpSession session) {
        LOG.info("getAllAtThisMonthOnControlCompletedInTime");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if (delegatedUser != null) {
            return docService.getAllAtThisMounthOnControlCompletedInTime(delegatedUser.getName());
        }
        return docService.getAllAtThisMounthOnControlCompletedInTime(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllAtThisMonthOnControlCompletedAfterTime(HttpSession session) {
        LOG.info("getAllAtThisMonthOnControlCompletedAfterTime");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if (delegatedUser != null) {
            return docService.getAllAtThisMounthOnControlCompletedAfterTime(delegatedUser.getName());
        }
        return docService.getAllAtThisMounthOnControlCompletedAfterTime(AuthorizedUser.getUserName());
    }

    public List<DocItemTo> getAllAtThisMonthOnControlNotCompleted(HttpSession session) {
        LOG.info("getAllAtThisMonthOnControlNotCompleted");
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.getAllAtThisMounthOnControlNotCompleted(delegatedUser.getName());
        } return docService.getAllAtThisMounthOnControlNotCompleted(AuthorizedUser.getUserName());
    }


    public List<DocNumberTo> getRegNumbers() {
        LOG.info("getRegNumbers");
        return docService.getRegNumbers();
    }

    public List<DocItemTo> getAll() {
        LOG.info("getAll");
        return docService.getAll();
    }

    public DocTo create(DocTo docTo, String rootPath, HttpSession session) {
        LOG.info("createFinal " + docTo);
        checkNew(docTo);
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser!= null) {
            return docService.save(docTo, delegatedUser.getName(), rootPath);
        }
        return docService.save(docTo, AuthorizedUser.getUserName(), rootPath);
    }

    public DocTo update(DocTo docTo, int id, String rootPath, HttpSession session) {
        LOG.info("update " + docTo);
        assureIdConsistent(docTo, id);
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.update(docTo, id, delegatedUser.getName(), rootPath, true);
        }
        return docService.update(docTo, id, AuthorizedUser.getUserName(), rootPath, false);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        docService.delete(id);
    }

    public DocTo rejectDocAgreement(int id,  String comment, HttpSession session) {
        LOG.info("returnDocAgreement " + id);
        User delegatedUser = (User)session.getAttribute("delegatedUser");
        if(delegatedUser != null) {
            return docService.rejectDocAgreement(id, delegatedUser.getName(), comment);
        }
        return docService.rejectDocAgreement(id, AuthorizedUser.getUserName(), comment);
    }

    public FileTo uploadFile(MultipartFile inputFile, String rootPath) {
        return docService.uploadFile(inputFile, rootPath);
    }

    public FileTo createDocx(DocTo docTo, String rootPath) {
        return docService.createDOCX(docTo, rootPath);
    }

    public FileTo createPDF(DocTo docTo, String rootPath) {
        return docService.createPDF(docTo, rootPath);
    }
}
