package com.clayder.championship.api.dto.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @NotEmpty(message = "Required field.")
    @Length(min = 2, max = 15, message = "The length must be between 2 and 15 characters.")
    private String email;

    @NotEmpty(message = "Required field.")
    @Length(min = 4, max = 8, message = "The length must be between 4 and 8 characters.")
    private String password;

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
