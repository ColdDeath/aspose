package ru.gbuac.service;

import ru.gbuac.model.Organization;
import ru.gbuac.model.User;
import ru.gbuac.to.UserTo;
import ru.gbuac.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

    List<User> getAllLdapUsers();

    User getByName(String name) throws NotFoundException;

    User get(int id) throws NotFoundException;

    List<UserTo> getAll();

    List<UserTo> getAllFiltered(String userName);

    User save(User user);

    User update(User user, int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    void deleteByName(String name) throws NotFoundException;

    void sinchronizeUsersByLdap();

    List<User> getDelegationUsers(String userName);
}
