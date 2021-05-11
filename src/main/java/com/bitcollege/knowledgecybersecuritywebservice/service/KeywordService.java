package com.bitcollege.knowledgecybersecuritywebservice.service;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Keyword;

import java.util.List;

public interface KeywordService {
    public List<Keyword> findTop4ByKnowledgeUnitIdAndSectorId(Long knowledgeUnitId, Long sectorId);
}
