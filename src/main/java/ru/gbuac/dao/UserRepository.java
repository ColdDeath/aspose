package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.gbuac.model.User;
import ru.gbuac.to.UserTo;

import java.util.List;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT u FROM User u WHERE lower(u.name)=lower(:name)")
    User getByName(@Param("name") String name);

    @Query("SELECT new ru.gbuac.to.UserTo(u.id, CONCAT(u.lastname, ' ', u.firstname, ' ', u.patronym), u.phone, u.position) " +
            "FROM User u ORDER BY u.lastname ASC")
    List<UserTo> getAll();

    @Query("SELECT du FROM User u JOIN u.delegationUsers du WHERE lower(u.name)=lower(:name)")
    List<User> getDelegationUsers(@Param("name") String name);
}
