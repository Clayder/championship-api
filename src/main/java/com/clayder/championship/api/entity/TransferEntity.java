package com.clayder.championship.api.entity;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Entity
@Data
@Table(name = "transfer")
@AllArgsConstructor
@NoArgsConstructor
public class TransferEntity  extends AbstractCoreEntity {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "origin_team_id")
    private TeamEntity originTeam;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_team_id")
    private TeamEntity destinationTeam;

    @Column
    private LocalDate date;

    @Column
    private Double amount;
}
