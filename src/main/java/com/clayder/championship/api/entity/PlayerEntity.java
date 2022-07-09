package com.clayder.championship.api.entity;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Entity
@Data
@Table(name = "player")
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity extends AbstractCoreEntity {

    @Column
    private String name;

    @Column
    private LocalDate birthday;

    @Column
    private String country;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private TeamEntity team;
}
