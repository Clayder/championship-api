package com.clayder.championship.api.entity;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Data
@Table(name = "game")
@AllArgsConstructor
@NoArgsConstructor
public class GameEntity extends AbstractCoreEntity {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "home_team_id")
    PlayerEntity homeTeam;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team_id")
    PlayerEntity team;

    @Column
    LocalDateTime start;

    @Column
    LocalDateTime finished;

    @Column
    LocalDateTime intervalGame;

    @Column
    int timeAddition;

    @JsonBackReference
    @OneToMany(mappedBy = "game")
    List<GolEntity> gols;

    @JsonBackReference
    @OneToMany(mappedBy = "game")
    List<ReplacementEntity> replacement;

    @JsonBackReference
    @OneToMany(mappedBy = "game")
    List<WarningEntity> warning;
}
