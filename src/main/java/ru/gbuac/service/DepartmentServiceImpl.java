package ru.gbuac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.gbuac.dao.DepartmentRepository;
import ru.gbuac.model.Department;
import ru.gbuac.to.DepartmentTo;
import ru.gbuac.util.exception.NotFoundException;

import java.util.List;

import static ru.gbuac.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public DepartmentTo get(int id) throws NotFoundException {
        return checkNotFoundWithId(departmentRepository.get(id).orElse(null), id);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department save(Department department) {
        Assert.notNull(department, "department must not be null");
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Department department, int id) throws NotFoundException {
        Assert.notNull(department, "department must not be null");
        Department savedDepartment = checkNotFoundWithId(departmentRepository.save(department), id);
        return savedDepartment;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Assert.notNull(id, "department must not be null");
        checkNotFoundWithId(departmentRepository.delete(id)!= 0, id);
    }

    @Override
    public List<Department> getAllTopLevel() {
        return departmentRepository.getAllTopLevel();
    }
}
