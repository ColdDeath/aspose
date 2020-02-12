package ru.gbuac.controller.department;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gbuac.model.Department;
import ru.gbuac.to.DepartmentTo;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = DepartmentRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentRestController extends AbstractDepartmentRestController{
    public static final String REST_URL = "/rest/profile/departments";

    @Override
    @GetMapping
    public List<Department> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value = "/{id}")
    public DepartmentTo get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Department updateOrCreate(@Valid @RequestBody Department department) {
        if (department.isNew()) {
            return super.create(department);
        } else {
            return super.update(department, department.getId());
        }
    }

    @Override
    @GetMapping(value = "/getAllTopLevel")
    public List<Department> getAllTopLevel() {
        return super.getAllTopLevel();
    }
}
