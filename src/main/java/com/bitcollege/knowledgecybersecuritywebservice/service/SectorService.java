package com.bitcollege.knowledgecybersecuritywebservice.service;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Sector;

import java.util.List;

public interface SectorService {
    public List<Sector> findByKnowledgeUnitId(Long knowledgeUnitId);
}
