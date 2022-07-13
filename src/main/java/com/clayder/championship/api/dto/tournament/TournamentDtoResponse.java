package com.clayder.championship.api.dto.tournament;

import com.clayder.championship.core.dto.AbstractDtoCore;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TournamentDtoResponse  extends AbstractDtoCore {
    private String name;
}
