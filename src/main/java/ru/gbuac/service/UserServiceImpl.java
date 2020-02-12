package ru.gbuac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.gbuac.AuthorizedUser;
import ru.gbuac.dao.RoleRepository;
import ru.gbuac.dao.UserRepository;
import ru.gbuac.model.User;
import ru.gbuac.to.UserTo;
import ru.gbuac.util.exception.NotFoundException;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.ldap.query.LdapQueryBuilder.query;
import static ru.gbuac.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired(required = true)
    @Qualifier(value = "ldapTemplate")
    private LdapTemplate ldapTemplate;

    @Autowired
    private RoleRepository roleRepository;

    private List<User> fetchLdapUsers() {
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        List<User> users = ldapTemplate.search(query().where("objectClass").is("person"), new UserAttributesMapper());
        return users.stream().filter(f->f.getFirstname() != null).collect(Collectors.toList());
    }

    @Override
    public List<User> getAllLdapUsers() {
        return fetchLdapUsers();
    }

    @Override
    public void sinchronizeUsersByLdap() {
        List<User> ldapUserList = fetchLdapUsers();
        for(User user: ldapUserList) {
            if (userRepository.getByName(user.getName()) == null) {
                userRepository.save(user);
            }
        }
    }

    @Override
    public User getByName(String name) throws NotFoundException {
        return userRepository.getByName(name);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(userRepository.findById(id).orElse(null), id);
    }

    @Override
    public List<UserTo> getAll() {
        return userRepository.getAll();
    }

    @Override
    public List<UserTo> getAllFiltered(String userName) {
        return userRepository.getAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user, int id) throws NotFoundException {
        Assert.notNull(user, "user must not be null");
        return checkNotFoundWithId(userRepository.save(user), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        userRepository.delete(id);
    }

     @Override
     public void deleteByName(String name) {
        userRepository.getByName(name);
     }


    @Override
    public List<User> getDelegationUsers(String userName) {
        return userRepository.getDelegationUsers(userName);
    }

    private class UserAttributesMapper implements AttributesMapper<User> {

        @Override
        public User mapFromAttributes(Attributes attributes) throws NamingException {
            User user;
            if (attributes == null) {
                return null;
            }
            user = new User();
            if (attributes.get("samaccountname") != null) {
                user.setName(attributes.get("samaccountname").get().toString());
            }

            if (attributes.get("name") != null && attributes.get("name").get().toString().split(" ").length == 3) {
                String[] nameAttrs = attributes.get("name").get().toString().split(" ");
                user.setLastname(nameAttrs[0]);
                user.setFirstname(nameAttrs[1]);
                user.setPatronym(nameAttrs[2]);
            }

            if (attributes.get("telephoneNumber") != null) {
                user.setPhone(attributes.get("telephoneNumber").get().toString());
            }

            if (attributes.get("position") != null) {
                user.setPhone(attributes.get("position").get().toString());
            }

            return user;
        }
}
    private class SingleAttributesMapper implements AttributesMapper<String> {

        @Override
        public String mapFromAttributes(Attributes attrs) throws NamingException {
            Attribute cn = attrs.get("cn");
            return cn.toString();
        }
    }
}