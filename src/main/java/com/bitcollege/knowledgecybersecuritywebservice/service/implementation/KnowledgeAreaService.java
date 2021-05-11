package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.KnowledgeAreaRepository;
import com.bitcollege.knowledgecybersecuritywebservice.entity.KnowledgeArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeAreaService implements com.bitcollege.knowledgecybersecuritywebservice.service.KnowledgeAreaService {

    @Autowired
    private KnowledgeAreaRepository knowledgeAreaRepository;

    @Override
    public List<KnowledgeArea> findAll() {
        return knowledgeAreaRepository.findAll();
    }
}
