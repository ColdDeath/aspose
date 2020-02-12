package ru.gbuac.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gbuac.model.Organization;
import ru.gbuac.service.OrganizationService;
import ru.gbuac.to.OrganizationTo;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = OrganizationRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationRestController extends AbstractOrganizationRestController {
    public static final String REST_URL = "/rest/profile/organizations";

    @Override
    @GetMapping(value = "/{id}")
    public Organization get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/get")
    public Organization getByInn(@RequestParam String inn) {
        return super.getByInn(inn);
    }

    @Override
    @GetMapping
    public List<OrganizationTo> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/getEGRULData")
    public Organization getEGRULData(@RequestParam String INN) {
        return super.getEGRULData(INN);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Organization updateOrCreate(@Valid @RequestBody Organization organization) {
        if (organization.isNew()) {
            return super.create(organization);
        } else {
            return super.update(organization, organization.getId());
        }
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(int id) {
        super.delete(id);
    }
}
