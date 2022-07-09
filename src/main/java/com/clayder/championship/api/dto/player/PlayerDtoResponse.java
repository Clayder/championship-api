package com.clayder.championship.api.dto.player;

import com.clayder.championship.api.entity.PlayerEntity;
import com.clayder.championship.api.entity.TeamEntity;
import com.clayder.championship.core.dto.AbstractDtoCore;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerDtoResponse extends AbstractDtoCore {
    private String name;
    private LocalDate birthday;
    private String country;
}
