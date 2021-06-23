package com.bitcollege.knowledgecybersecuritywebservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordRequestDTO {
    private String email;
    private String password;
    private String secretQuestion;
    private String secretAnswer;
}
