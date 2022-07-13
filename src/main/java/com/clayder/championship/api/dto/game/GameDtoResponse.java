package com.clayder.championship.api.dto.game;

import com.clayder.championship.api.entity.GolEntity;
import com.clayder.championship.api.entity.ReplacementEntity;
import com.clayder.championship.api.entity.TeamEntity;
import com.clayder.championship.api.entity.WarningEntity;
import com.clayder.championship.core.dto.AbstractDtoCore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameDtoResponse extends AbstractDtoCore {

    private TeamEntity homeTeam;
    private TeamEntity team;
    private LocalDateTime start;
    private LocalDateTime finished;
    private LocalDateTime intervalGame;
    private int timeAddition;
    private List<GolEntity> gols;
    private List<ReplacementEntity> replacement;
    private List<WarningEntity> warning;
}
