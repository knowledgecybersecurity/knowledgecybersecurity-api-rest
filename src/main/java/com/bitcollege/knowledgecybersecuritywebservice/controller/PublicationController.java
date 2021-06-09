package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.dto.PublicationDTO;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Publication;
import com.bitcollege.knowledgecybersecuritywebservice.service.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publications")
public class PublicationController {

    @Autowired
    private IPublicationService publicationService;


    @PostMapping(value = "/create")
    public ResponseEntity<?> register(@RequestBody PublicationDTO publicationDTO) {
        try {
            Publication publicationSaved = this.publicationService.create(publicationDTO);
            return ResponseEntity.status(HttpStatus.OK).body(publicationSaved);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping(value = "/listAll")
    public ResponseEntity<?> findAll() {
        try {
            List<Publication> publicationList = this.publicationService.list();
            return ResponseEntity.status(HttpStatus.OK).body(publicationList);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Publication publicationt = this.publicationService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(publicationt);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
