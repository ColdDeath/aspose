package ru.gbuac.repository;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import ru.gbuac.dao.RoleRepository;
import ru.gbuac.dao.UserRepository;
import ru.gbuac.model.Role;
import ru.gbuac.model.User;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public abstract class AbsractRepositoryTest {

    protected MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private FilterChainProxy filterChainProxy;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @PostConstruct
    public void setup() throws Exception {
        mockMvc = webAppContextSetup(webApplicationContext)
                .dispatchOptions(true)
                .addFilters(filterChainProxy)
                .build();
    }

    public User getUser() {
        return new User("user1", "Pupkin", "Vasya", "Vasilievich", "vasya@tut.ru", "123456", "specialist");
    }

    public User getUser2() {
        return new User("user2", "Sokolov", "Eugeny", "Ivanovich", "sokol@tut.ru", "354553", "expert");
    }

    public Role getRole() {
        return new Role("Тестовая роль 1");
    }

    public Role getRole2() {
        return new Role("Тестовая роль 2");
    }

    @Before
    public void clearRepository() {
        for (User user : userRepository.findAll()) {
            userRepository.delete(user.getId());
        }
    }
}
