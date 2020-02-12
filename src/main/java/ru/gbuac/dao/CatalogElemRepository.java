package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.Catalog;
import ru.gbuac.model.CatalogElem;
import ru.gbuac.model.DocTypeFields;

import java.util.List;

@Transactional(readOnly = true)
public interface CatalogElemRepository extends JpaRepository<CatalogElem, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM CatalogElem c WHERE c.id=:id AND c.catalog.id=:catalogId")
    int delete(@Param("id") int id, @Param("catalogId") int catalogId);

    @Query("SELECT c FROM CatalogElem c WHERE c.catalog.id=:catalogId ORDER BY c.id ASC")
    List<CatalogElem> getAll(@Param("catalogId") int catalogId);

    @Query("SELECT c FROM CatalogElem c WHERE c.catalog.id=:catalogId AND c.idParentCatalogElem.id=:idParentCatalogElem ORDER BY c.id ASC")
    List<CatalogElem> getAllByParentCatalogElem(@Param("catalogId") int catalogId, @Param("idParentCatalogElem") int idParentCatalogElem);

    @Query("SELECT distinct c.catalog FROM CatalogElem c WHERE c.idParentCatalogElem.id=:id")
    List<Catalog> getCatalogChildsByElem(@Param("id") int id);
}
