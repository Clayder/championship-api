package com.clayder.championship.api.entity;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Builder
@Entity
@Data
@Table(name = "transfer")
@AllArgsConstructor
@NoArgsConstructor
public class TransferEntity  extends AbstractCoreEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "origin_team_id")
    private TeamEntity originTeam;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_team_id")
    private TeamEntity destinationTeam;

    @Column
    private LocalDate date;

    @Column
    private Double amount;
}
