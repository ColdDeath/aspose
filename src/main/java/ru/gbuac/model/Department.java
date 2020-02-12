package ru.gbuac.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "department")
public class Department extends NamedEntity {

    @Column(name="top_level")
    private boolean topLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chief_user_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User chiefUser;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.ALL)
    private List<User> users;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Department> childDepartments;
}
