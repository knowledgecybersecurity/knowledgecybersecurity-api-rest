package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Certificate;
import com.bitcollege.knowledgecybersecuritywebservice.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    @GetMapping("/knowledge-units/{kuId}/certificates")
    public List<Certificate> findByKnowledgeUnit(@PathVariable Long kuId){
        return certificateService.findByKnowledgeUnitId(kuId);
    }
}
