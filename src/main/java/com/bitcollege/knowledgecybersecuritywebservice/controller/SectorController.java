package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Sector;
import com.bitcollege.knowledgecybersecuritywebservice.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SectorController {
    @Autowired
    private SectorService sectorService;

    @GetMapping("/knowledge-units/{kuId}/sectors")
    public List<Sector> findByKnowledgeUnit(@PathVariable Long kuId){
        return sectorService.findByKnowledgeUnitId(kuId);
    }
}
