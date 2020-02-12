package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.DocTypeFields;
import ru.gbuac.model.DocValuedFields;

import java.util.List;

@Transactional(readOnly = true)
public interface DocValuedFieldsRepository extends JpaRepository<DocValuedFields, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM DocValuedFields d WHERE d.id=:id AND d.doc.id=:docId")
    int delete(@Param("id") int id, @Param("docId") int docId);

    @Transactional
    @Modifying
    @Query("DELETE FROM DocValuedFields d WHERE d.doc.id=:docId")
    int deleteAll(@Param("docId") int docId);

    @Query("SELECT d FROM DocValuedFields d WHERE d.doc.id=:docId ORDER BY d.position ASC")
    List<DocValuedFields> getAll(@Param("docId") int docId);
}
