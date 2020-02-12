package ru.gbuac.model;

import lombok.*;
import ru.gbuac.HasId;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements HasId {
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;
}