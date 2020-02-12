package ru.gbuac.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "fields_roles")
public class FieldsRoles extends BaseEntity {
    @Column(name = "doctype_id", nullable = false)
    @JsonIgnore
    private int docTypeId;

    @Column(name = "field_id", nullable = false)
    @JsonIgnore
    private int fieldId;

    @NotNull
    private Boolean required;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = true)
    @JsonIgnore
    private Role role;
}
