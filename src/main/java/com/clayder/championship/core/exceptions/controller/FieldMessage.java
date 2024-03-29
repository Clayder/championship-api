package com.clayder.championship.core.exceptions.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldMessage {
    private String fieldName;
    private String message;

}
