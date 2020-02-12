package ru.gbuac.controller.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gbuac.AuthorizedUser;
import ru.gbuac.model.Organization;
import ru.gbuac.service.OrganizationService;
import ru.gbuac.to.DocTo;
import ru.gbuac.to.OrganizationTo;

import javax.validation.Valid;
import java.util.List;

import static ru.gbuac.util.ValidationUtil.assureIdConsistent;
import static ru.gbuac.util.ValidationUtil.checkNew;

public abstract class AbstractOrganizationRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    OrganizationService organizationService;

    public Organization get(int id) {
        LOG.info("get");
        return organizationService.get(id);
    }

    public Organization getByInn(String inn) {
        LOG.info("getByInn");
        return organizationService.getByInn(inn);
    }
    public List<OrganizationTo> getAll() {
        LOG.info("getAll");
        return organizationService.getAll();
    }

    public Organization getEGRULData(String INN) {
        LOG.info("getEGRULData");
        return organizationService.getEGRULData(INN);
    }

    public Organization create(Organization organization) {
        LOG.info("create " + organization);
        checkNew(organization);
        return organizationService.save(organization);
    }

    public Organization update(Organization organization, int id) {
        LOG.info("update " + organization);
        assureIdConsistent(organization, id);
        return organizationService.update(organization, id);
    }

    public void delete(int id) {
        LOG.info("delete");
        organizationService.delete(id);
    }
}
