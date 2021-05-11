package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.CongressRepository;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Congress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongressService implements com.bitcollege.knowledgecybersecuritywebservice.service.CongressService {

    @Autowired
    private CongressRepository congressRepository;

    @Override
    public List<Congress> findByKnowledgeUnitId(Long knowledgeUnitId) {
        return congressRepository.findByKnowledgeUnitId(knowledgeUnitId);
    }
}
