package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.KnowledgeUnitRepository;
import com.bitcollege.knowledgecybersecuritywebservice.entity.KnowledgeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeUnitService implements com.bitcollege.knowledgecybersecuritywebservice.service.KnowledgeUnitService{

    @Autowired
    private KnowledgeUnitRepository knowledgeUnitRepository;

    @Override
    public List<KnowledgeUnit> findAll() {
        return knowledgeUnitRepository.findAll();
    }
}
