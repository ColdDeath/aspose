package ru.gbuac.controller.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gbuac.model.User;
import ru.gbuac.to.UserTo;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = UserRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController extends AbstractUserRestController {
    public static final String REST_URL = "/rest/profile/users";

    @Override
    @GetMapping(value = "/{id}")
    public User get(@PathVariable("id") int id) {
        return super.get(id);
    }


    @Override
    @GetMapping(value = "/getAllLdapUsers")
    public List<User> getAllLdapUsers() {
        return super.getAllLdapUsers();
    }

    @Override
    @GetMapping(value = "/getByName")
    User getByName(@RequestParam("name") String name) {
        return super.getByName(name);
    }

    @Override
    @GetMapping
    List<UserTo> getAll() {
       return super.getAll();
    }

    @Override
    @GetMapping(value = "/filtered")
    List<UserTo> getAllFiltered() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/sinchronizeUsersByLdap", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sinchronizeUsersByLdap() {
        super.sinchronizeUsersByLdap();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateOrCreate(@Valid @RequestBody User user) {
        if (user.isNew()) {
            return super.create(user);
        } else {
            return super.update(user, user.getId());
        }
    }

    @Override
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @DeleteMapping(value = "/deleteByName")
    void deleteByName(@RequestParam("name") String name) {
        super.deleteByName(name);
    }

    @Override
    @GetMapping(value = "/getDelegationUsers")
    public List<User> getDelegationUsers() {
        return super.getDelegationUsers();
    }

    @Override
    @PostMapping(value = "/setDelegatedUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setDelegatedUser(@RequestParam("name") String userName, HttpSession session) {
        super.setDelegatedUser(userName, session);
    }

    @Override
    @GetMapping(value = "/getDelegatedUser")
    public User getDelegatedUser(HttpSession session) {
        return super.getDelegatedUser(session);
    }
}