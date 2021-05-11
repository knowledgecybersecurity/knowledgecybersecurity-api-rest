package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Ksat;
import com.bitcollege.knowledgecybersecuritywebservice.service.KsatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KsatController {
    @Autowired
    private KsatService ksatService;

    @GetMapping("/work-roles/{wrId}/ksat")
    public List<Ksat> findByKnowledgeUnit(@PathVariable Long wrId){
        return ksatService.findByWorkRoleId(wrId);
    }
}
