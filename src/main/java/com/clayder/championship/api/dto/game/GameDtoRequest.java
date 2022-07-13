package com.clayder.championship.api.dto.game;

import com.clayder.championship.core.dto.AbstractDtoCore;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameDtoRequest extends AbstractDtoCore {
    private Long homeTeamId;
    private Long teamId;
}
