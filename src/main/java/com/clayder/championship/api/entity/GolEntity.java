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
@Table(name = "gol")
@AllArgsConstructor
@NoArgsConstructor
public class GolEntity extends AbstractCoreEntity {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private GameEntity game;
}
