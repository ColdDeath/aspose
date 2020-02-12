package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.Department;
import ru.gbuac.to.DepartmentTo;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Department d WHERE d.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT d FROM Department d WHERE d.topLevel=TRUE")
    List<Department> getAllTopLevel();

    @Query("SELECT d FROM Department d JOIN d.users u WHERE lower(u.name)=lower(:userName)")
    Optional<Department> getByUserName(@Param("userName") String userName);

    @Query("SELECT new ru.gbuac.to.DepartmentTo(d.id, d.name) FROM Department d WHERE d.id=:id")
    Optional<DepartmentTo> get(@Param("id") int id);

    @Query(value = "SELECT d.* FROM department d WHERE d.id IN " +
            "(SELECT c.department_id FROM department dd, department_child_departments c WHERE dd.id = c.child_departments_id AND dd.id = :id) " +
            "AND d.top_level=TRUE",
            nativeQuery = true)
    Optional<Department> getTopLevelForDepartment(@Param("id") int id);


}
