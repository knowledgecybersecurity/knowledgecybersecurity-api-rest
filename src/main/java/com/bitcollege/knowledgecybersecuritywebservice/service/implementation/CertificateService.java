package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.CertificateRepository;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Certificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService implements com.bitcollege.knowledgecybersecuritywebservice.service.CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Override
    public List<Certificate> findByKnowledgeUnitId(Long knowledgeUnitId) {
        return certificateRepository.findByKnowledgeUnitId(knowledgeUnitId);
    }
}
