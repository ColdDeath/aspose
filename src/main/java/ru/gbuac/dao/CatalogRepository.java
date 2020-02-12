package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.Catalog;

@Transactional(readOnly = true)
public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Catalog c WHERE c.id=:id")
    int delete(@Param("id") int id);
}
