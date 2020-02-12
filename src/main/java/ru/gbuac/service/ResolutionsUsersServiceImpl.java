package ru.gbuac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gbuac.dao.DepartmentRepository;
import ru.gbuac.dao.DocRepository;
import ru.gbuac.dao.ResolutionsUsersRepository;
import ru.gbuac.dao.UserRepository;
import ru.gbuac.model.*;
import ru.gbuac.util.exception.IllegalResolutionUserException;
import ru.gbuac.util.exception.NotFoundException;
import ru.gbuac.util.exception.ResolutionUserNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResolutionsUsersServiceImpl implements ResolutionsUsersService {

    @Autowired
    private ResolutionsUsersRepository resolutionsUsersRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DocRepository docRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Override
    public ResolutionsUsers save(int userId, int docId) {
        User user = userRepository.findById(userId).orElse(null);
        Doc doc = docRepository.findById(docId).orElse(null);

        for (Resolution resolution: doc.getResolutions()) {
            List<Integer> depIds = resolution.getDepartment()
                    .getChildDepartments().stream().map(d -> d.getId()).collect(Collectors.toList());
            depIds.add(resolution.getDepartment().getId());
            if (depIds.contains(user.getDepartment().getId())) {
                ResolutionsUsers toSave = new ResolutionsUsers(null, LocalDateTime.now(), user, resolution);
                ResolutionsUsers saved = resolutionsUsersRepository.save(toSave);
                mailService.sendExecutionEmail(user.getEmail(), doc.getId(), doc.getRegNum());
                return saved;
            }
        }
        throw new IllegalResolutionUserException();
    }

    @Override
    public void delete(int userId, int docId) throws NotFoundException {
        User user = userRepository.findById(userId).orElse(null);
        Doc doc = docRepository.findById(docId).orElse(null);
        boolean found = false;

        for (Resolution resolution: doc.getResolutions()) {
            List<Integer> depIds = resolution.getDepartment()
                    .getChildDepartments().stream().map(d -> d.getId()).collect(Collectors.toList());
            depIds.add(resolution.getDepartment().getId());
            if (depIds.contains(user.getDepartment().getId())) {
                ResolutionsUsers resolutionsUsers =
                        resolution.getResolutionsUsers()
                                .stream().filter(ru -> ru.getUser().getId() == userId).findFirst().orElse(null);
                if (resolutionsUsers != null) {
                    resolutionsUsersRepository.delete(resolutionsUsers.getId());
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            throw new ResolutionUserNotFoundException();
        }
    }
}
