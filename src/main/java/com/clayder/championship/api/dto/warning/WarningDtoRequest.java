package com.clayder.championship.api.dto.warning;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WarningDtoRequest {
    private Long playerId;
}
