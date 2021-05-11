package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.KnowledgeObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KnowledgeObjectiveService implements com.bitcollege.knowledgecybersecuritywebservice.service.KnowledgeObjectiveService {

    @Autowired
    private KnowledgeObjectiveRepository knowledgeObjectiveRepository;


    @Override
    public List<Map<String, Object>> findByKnowledgeUnitIdAndSectorId(Long knowledgeUnitId, Long sectorId) {
        return knowledgeObjectiveRepository.findByKnowledgeUnitIdAndSectorId(knowledgeUnitId,sectorId);
    }
}
