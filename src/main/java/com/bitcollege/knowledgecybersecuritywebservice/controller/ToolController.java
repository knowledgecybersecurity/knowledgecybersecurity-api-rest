package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Tool;
import com.bitcollege.knowledgecybersecuritywebservice.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToolController {
    @Autowired
    private ToolService toolService;

    @GetMapping("/knowledge-units/{kuId}/tools")
    public List<Tool> findByKnowledgeUnit(@PathVariable Long kuId){
        return toolService.findByKnowledgeUnitId(kuId);
    }
}
