package ru.gbuac.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.PublishData;

@Transactional(readOnly = true)
public interface PublishDataRepository extends JpaRepository<PublishData, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Organization o WHERE o.id=:id")
    void delete(@Param("id") int id);
}
