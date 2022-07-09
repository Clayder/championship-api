package com.clayder.championship.api.dto.player;

import com.clayder.championship.api.entity.TeamEntity;
import com.clayder.championship.core.dto.AbstractDtoCore;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerDtoRequest {
    private String name;
    private LocalDate birthday;
    private String country;
}
