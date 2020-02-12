package ru.gbuac.controller.resolutionsusers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gbuac.controller.organization.AbstractOrganizationRestController;
import ru.gbuac.model.Organization;
import ru.gbuac.model.ResolutionsUsers;
import ru.gbuac.to.OrganizationTo;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = ResolutionsUsersRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ResolutionsUsersRestController extends AbstractResolutionsUsersRestController {
    public static final String REST_URL = "/rest/profile/docs/{docId}";

    @Override
    @PostMapping(value = "/addExecutorUser/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResolutionsUsers save(@PathVariable("userId")int userId, @PathVariable("docId")int docId) {
        return super.save(userId, docId);
    }

    @Override
    @DeleteMapping(value = "/removeExecutorUser/{userId}")
    public void delete(@PathVariable("userId")int userId, @PathVariable("docId")int docId) {
        super.delete(userId, docId);
    }
}
