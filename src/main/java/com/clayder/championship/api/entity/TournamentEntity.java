package com.clayder.championship.api.entity;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Data
@Table(name = "tournament")
@AllArgsConstructor
@NoArgsConstructor
public class TournamentEntity extends AbstractCoreEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<GameEntity> games;
}
