package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.HtmlTable;

@Transactional(readOnly = true)
public interface HtmlTableRepository extends JpaRepository<HtmlTable, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM HtmlTable u WHERE u.id=:id")
    int delete(@Param("id") int id);
}
