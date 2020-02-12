package ru.gbuac.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "publish_data")
public class PublishData extends BaseEntity {
    @NotNull
    @Column(name = "mosru")
    private boolean mosRu;

    @Column(name = "mosru_datetime")
    private LocalDateTime mosRuDateTime;

    @Column(name = "basereg")
    private Integer basereg;

    @Column(name = "basereg_datetime")
    private LocalDateTime baseregDateTime;

    @Column(name = "ri")
    private boolean ri;

    @Column(name = "ri_datetime")
    private LocalDateTime riDateTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Doc doc;

    public PublishData(Doc doc) {
        this.doc = doc;
    }
}