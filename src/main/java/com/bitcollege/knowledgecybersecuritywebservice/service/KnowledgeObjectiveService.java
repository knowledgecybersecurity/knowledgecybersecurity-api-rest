package com.bitcollege.knowledgecybersecuritywebservice.service;

import java.util.List;
import java.util.Map;

public interface KnowledgeObjectiveService {
    public List<Map<String, Object >> findByKnowledgeUnitIdAndSectorId(Long knowledgeUnitId, Long sectorId);
}
