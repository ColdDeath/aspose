package ru.gbuac.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "resolutions_users")
public class ResolutionsUsers extends BaseEntity {

    @Column(name = "resolution_datetime")
    private LocalDateTime resolutionDateTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "resolution_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Resolution resolution;

    public ResolutionsUsers(Integer id, LocalDateTime resolutionDateTime, User user, Resolution resolution) {
        super(id);
        this.resolutionDateTime = resolutionDateTime;
        this.user = user;
        this.resolution = resolution;
    }
}
