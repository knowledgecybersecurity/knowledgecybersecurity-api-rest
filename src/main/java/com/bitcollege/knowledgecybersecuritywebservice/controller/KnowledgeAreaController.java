package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.entity.KnowledgeArea;
import com.bitcollege.knowledgecybersecuritywebservice.service.KnowledgeAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KnowledgeAreaController {

    final String basePath = "/knowledge-area";

    @Autowired
    private KnowledgeAreaService knowledgeAreaService;

    @GetMapping("/knowledge-areas")
    public List<KnowledgeArea> findAll(){
        return knowledgeAreaService.findAll();
    }

}
