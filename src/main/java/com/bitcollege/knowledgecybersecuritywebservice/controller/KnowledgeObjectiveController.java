package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.service.KnowledgeObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class KnowledgeObjectiveController {
    @Autowired
    private KnowledgeObjectiveService knowledgeObjectiveService;

    @GetMapping("/knowledge-units/{kuId}/sectors/{sId}/knowledge-objectives")
    public List<Map<String, Object >> findByKnowledgeUnit(@PathVariable Long kuId, @PathVariable Long sId){
        return knowledgeObjectiveService.findByKnowledgeUnitIdAndSectorId(kuId,sId);
    }
}
