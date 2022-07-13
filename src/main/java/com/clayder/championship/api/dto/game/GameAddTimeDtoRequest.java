package com.clayder.championship.api.dto.game;

import com.clayder.championship.core.dto.AbstractDtoCore;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameAddTimeDtoRequest extends AbstractDtoCore {
    private Integer addTime;
}
