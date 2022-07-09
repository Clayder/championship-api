package com.clayder.championship.api.dto.team;

import com.clayder.championship.core.dto.AbstractDtoCore;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeamDtoResponse extends AbstractDtoCore {
    private String name;
    private String locale;
}
