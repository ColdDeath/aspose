package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.Organization;
import ru.gbuac.to.OrganizationTo;

import java.util.List;

@Transactional(readOnly = true)
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Organization o WHERE o.id=:id")
    void delete(@Param("id") int id);

    @Query("SELECT o FROM Organization o WHERE o.inn=:inn")
    Organization getByInn(@Param("inn") String inn);

    @Query("SELECT new ru.gbuac.to.OrganizationTo(o.id, o.shortNameLf) FROM Organization o")
    List<OrganizationTo> getAll();
}
