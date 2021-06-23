package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.dto.GetUserDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.InitResetPasswordResponseDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.ResetPasswordRequestDTO;
import com.bitcollege.knowledgecybersecuritywebservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resetpassword")
public class ResetPassword {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/innitreset/{email}")
    public ResponseEntity<?> innitreset(@PathVariable String email) {
        try {
            InitResetPasswordResponseDTO initResetPasswordResponseDTO = this.userService.initResetPassword(email);
            return ResponseEntity.status(HttpStatus.OK).body(initResetPasswordResponseDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }

    }

    @PutMapping(value = "/innitreset")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequestDTO resetPasswordRequestDTO) {
        try {
            ResetPasswordRequestDTO resetPassword = this.userService.resetPassword(resetPasswordRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(resetPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }

    }

}
