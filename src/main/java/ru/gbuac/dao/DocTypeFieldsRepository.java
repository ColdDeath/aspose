package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.DocTypeFields;

import java.util.List;

@Transactional(readOnly = true)
public interface DocTypeFieldsRepository extends JpaRepository<DocTypeFields, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM DocTypeFields d WHERE d.id=:id AND d.docType.id=:docTypeId")
    int delete(@Param("id") int id, @Param("docTypeId") int docTypeId);

    @Query("SELECT d FROM DocTypeFields d WHERE d.docType.id=:docTypeId ORDER BY d.position ASC")
    List<DocTypeFields> getAll(@Param("docTypeId") int docTypeId);
}
