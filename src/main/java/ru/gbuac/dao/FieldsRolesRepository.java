package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.FieldsRoles;

import java.util.List;

@Transactional(readOnly = true)
public interface FieldsRolesRepository extends JpaRepository<FieldsRoles, Integer> {
    @Query("SELECT f FROM FieldsRoles f WHERE f.docTypeId=:docTypeId")
    List<FieldsRoles> getAll(@Param("docTypeId") int docTypeId);
}
