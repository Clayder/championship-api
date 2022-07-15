package com.clayder.championship.api.dto.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {

    @NotEmpty(message = "Required field.")
    private String token;

    @NotEmpty(message = "Required field.")
    private String type;
}
