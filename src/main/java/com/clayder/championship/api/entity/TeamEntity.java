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
@Table(name = "team")
@AllArgsConstructor
@NoArgsConstructor
public class TeamEntity extends AbstractCoreEntity {

    @Column
    private String name;

    @Column
    private String locale;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PlayerEntity> players;

}
