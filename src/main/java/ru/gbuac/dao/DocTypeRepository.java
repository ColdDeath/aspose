package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.DocType;

@Transactional(readOnly = true)
public interface DocTypeRepository extends JpaRepository<DocType, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM DocType d WHERE d.id=:id")
    int delete(@Param("id") int id);
}
