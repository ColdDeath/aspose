package ru.gbuac.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "resolution")
public class Resolution extends BaseEntity {

    @Column(name = "ordering")
    Integer ordering;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Doc doc;

    @Column(name = "primary_resolution")
    private boolean primaryResolution;

    @Column(name = "control_date")
    private LocalDate controlDate;

    @Column(name = "execution_datetime")
    private LocalDateTime executionDateTime;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resolution", cascade = CascadeType.ALL)
    private List<ResolutionsUsers> resolutionsUsers;

    public Resolution(Integer id, Integer ordering, Doc doc, boolean primaryResolution, Department department) {
        super(id);
        this.ordering = ordering;
        this.doc = doc;
        this.primaryResolution = primaryResolution;
        this.department = department;
    }
}
