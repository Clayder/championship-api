package com.clayder.championship.api.entity;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Data
@Table(name = "replacement")
@AllArgsConstructor
@NoArgsConstructor
public class ReplacementEntity extends AbstractCoreEntity {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "player_output_id")
    private PlayerEntity playerOutput;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "leave_player_id")
    private PlayerEntity leavePlayer ;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private GameEntity game;
}
