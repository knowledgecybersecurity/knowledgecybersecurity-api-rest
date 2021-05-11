package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.entity.KnowledgeUnit;
import com.bitcollege.knowledgecybersecuritywebservice.service.KnowledgeUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KnowledgeUnitController {

    @Autowired
    private KnowledgeUnitService knowledgeUnitService;

    @GetMapping("/knowledge-units")
    public List<KnowledgeUnit> findAll(){
        return knowledgeUnitService.findAll();
    }
}
