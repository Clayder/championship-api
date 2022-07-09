package com.clayder.championship.api.entity;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

//    @JsonBackReference
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PlayerEntity> players;

}
