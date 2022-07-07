package com.clayder.championship.api.entity;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Builder
@Entity
@Data
@Table(name = "player")
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity extends AbstractCoreEntity {

    @Column
    private String name;

    @Column
    private LocalDate birthday;

    @Column
    private String country;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "team_id")
    private TeamEntity team;}
