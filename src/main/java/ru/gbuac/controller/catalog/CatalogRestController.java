package ru.gbuac.controller.catalog;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gbuac.model.Catalog;
import java.util.List;

@RestController
@RequestMapping(value = CatalogRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogRestController extends AbstractCatalogRestController {
    public static final String REST_URL = "/rest/profile/catalogs";

    @Override
    @GetMapping(value = "/{id}")
    public Catalog get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/childs/{elementId}")
    public List<Catalog> getChildCatalogsByElementId(@PathVariable("elementId") int elementId) {
        return super.getChildCatalogsByElementId(elementId);
    }

    @Override
    @GetMapping
    public List<Catalog> getAll() {
        return super.getAll();
    }
}
