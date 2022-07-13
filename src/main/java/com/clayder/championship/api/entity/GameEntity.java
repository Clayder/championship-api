package com.clayder.championship.api.entity;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Data
@Table(name = "game")
@AllArgsConstructor
@NoArgsConstructor
public class GameEntity extends AbstractCoreEntity {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "home_team_id")
    private TeamEntity homeTeam;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @Column
    private LocalDateTime start;

    @Column
    private LocalDateTime finished;

    @Column
    private LocalDateTime intervalGame;

    @Column
    private int timeAddition;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tournament_id", referencedColumnName = "id")
    private TournamentEntity tournament;

    @OneToMany(mappedBy = "game")
    private List<GolEntity> gols;

    @OneToMany(mappedBy = "game")
    private List<ReplacementEntity> replacement;

    @OneToMany(mappedBy = "game")
    private List<WarningEntity> warning;
}
