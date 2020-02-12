package ru.gbuac.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.SafeHtml;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User extends NamedEntity {
    @Column(name = "lastname")
    @SafeHtml
    private String lastname;

    @Column(name = "firstname")
    @SafeHtml
    private String firstname;

    @Column(name = "patronym")
    @SafeHtml
    private String patronym;

    @Column(name = "position")
    @SafeHtml
    private String position;

    @Column(name = "short_position")
    @SafeHtml
    private String shortPosition;

    @Column(name = "full_position")
    @SafeHtml
    private String fullPosition;

    @Column(name = "dative_fullname")
    @SafeHtml
    private String dativeFullname;

    @Column(name = "dative_position")
    @SafeHtml
    private String dativePosition;

    @Column(name = "email")
    @SafeHtml
    private String email;

    @Column(name = "phone")
    @SafeHtml
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Department> distributionDepartments;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> delegationUsers;

    public User(@NotBlank @SafeHtml String name, String lastname, String firstname, String patronym, String email,
                String phone, String position) {
        super(name);
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronym = patronym;
        this.email = email;
        this.phone = phone;
        this.position = position;
    }
}
