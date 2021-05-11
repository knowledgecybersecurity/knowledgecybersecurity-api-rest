package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Keyword;
import com.bitcollege.knowledgecybersecuritywebservice.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class KeywordController {

    @Autowired
    private KeywordService keywordService;

    @GetMapping("/knowledge-units/{kuId}/sectors/{sId}/keywords")
    public List<Keyword> findByKnowledgeUnit(@PathVariable Long kuId, @PathVariable Long sId){
        return keywordService.findTop4ByKnowledgeUnitIdAndSectorId(kuId, sId);
    }
}


