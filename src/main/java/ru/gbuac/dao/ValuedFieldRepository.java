package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.ValuedField;

@Transactional(readOnly = true)
public interface ValuedFieldRepository extends JpaRepository<ValuedField, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM ValuedField v WHERE v.id=:id")
    int delete(@Param("id") int id);
}
