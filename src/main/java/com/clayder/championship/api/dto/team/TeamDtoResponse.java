package com.clayder.championship.api.dto.team;

import com.clayder.championship.api.entity.PlayerEntity;
import com.clayder.championship.core.dto.AbstractDtoCore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeamDtoResponse extends AbstractDtoCore {
    private String name;
    private String locale;
    private List<PlayerEntity> players;
}
