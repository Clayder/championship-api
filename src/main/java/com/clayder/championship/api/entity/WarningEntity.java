package com.clayder.championship.api.entity;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Builder
@Entity
@Data
@Table(name = "warning")
@AllArgsConstructor
@NoArgsConstructor
public class WarningEntity extends AbstractCoreEntity {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "player_id")
    PlayerEntity player;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "game_id")
    GameEntity game;
}
