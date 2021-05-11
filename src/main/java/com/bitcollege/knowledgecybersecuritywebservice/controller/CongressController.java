package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Congress;
import com.bitcollege.knowledgecybersecuritywebservice.service.CongressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CongressController {
    @Autowired
    private CongressService congressService;

    @GetMapping("/knowledge-units/{kuId}/congresses")
    public List<Congress> findByKnowledgeUnit(@PathVariable Long kuId){
        return congressService.findByKnowledgeUnitId(kuId);
    }
}
