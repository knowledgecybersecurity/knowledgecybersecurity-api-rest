package com.bitcollege.knowledgecybersecuritywebservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InitResetPasswordResponseDTO {
    private String email;
    private String secretQuestion;
}
