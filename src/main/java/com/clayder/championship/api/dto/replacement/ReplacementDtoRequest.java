package com.clayder.championship.api.dto.replacement;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReplacementDtoRequest {
    private Long playerOutputId;
    private Long leavePlayerId ;
}
