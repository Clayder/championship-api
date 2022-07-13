package com.clayder.championship.api.dto.player;

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
