package ru.gbuac.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import ru.gbuac.model.Role;
import ru.gbuac.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RoleRepositoryTest extends AbsractRepositoryTest {
    @Test
    public void get() {
        Role savedRole = roleRepository.save(getRole());
        Role returnedRoles = roleRepository.findById(savedRole.getId()).orElse(null);
        Assert.assertEquals(savedRole, returnedRoles);
    }

    @Test
    public void getAll() {
        List<Role> existedRoles = roleRepository.findAll();
        Role savedRole1 = roleRepository.save(getRole());
        Role savedRole2 = roleRepository.save(getRole2());
        List<Role> returnedRoles = roleRepository.findAll();
        existedRoles.add(savedRole1);
        existedRoles.add(savedRole2);
        Assert.assertEquals(existedRoles, returnedRoles);
    }

    @Test
    public void create() {
        Role role = getRole();
        Role savedRole = roleRepository.save(role);
        Assert.assertEquals(role, savedRole);
    }

    @Test
    public void update() {
        Role savedRole = roleRepository.save(getRole());
        savedRole.setName("председатель");
        Role updatedRole = roleRepository.save(savedRole);
        Assert.assertEquals(updatedRole, savedRole);
    }

    @Test
    public void delete() {
        List<Role> existedRoles = roleRepository.findAll();
        Role savedRole = roleRepository.save(getRole());
        List<Role> returnedRoles = roleRepository.findAll();
        existedRoles.add(savedRole);
        roleRepository.delete(savedRole.getId());
        Assert.assertEquals(existedRoles, returnedRoles);

    }

    @Test
    public void getRolesByUsername() {
        Role savedRole1 = roleRepository.save(getRole());
        Role savedRole2 = roleRepository.save(getRole2());
        User newUser = getUser();
        savedRole1.setUsers(Arrays.asList(newUser));
        savedRole2.setUsers(Arrays.asList(newUser));
        newUser.setRoles(Arrays.asList(savedRole1, savedRole2));
        User returnedUser = userRepository.save(newUser);
        List<Role> returnedRoles = roleRepository.getRolesByUsername(returnedUser.getName());
        Assert.assertEquals(Arrays.asList(savedRole1, savedRole2), returnedRoles);
    }
}