package ru.gbuac.controller.resolutionsusers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gbuac.model.ResolutionsUsers;
import ru.gbuac.service.ResolutionsUsersService;


public abstract class AbstractResolutionsUsersRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    ResolutionsUsersService resolutionsUsersService;

    public ResolutionsUsers save(int userId, int docId) {
        LOG.info("save");
        return resolutionsUsersService.save(userId, docId);
    }

    public void delete(int userId, int docId) {
        LOG.info("delete");
        resolutionsUsersService.delete(userId, docId);
    }
}
