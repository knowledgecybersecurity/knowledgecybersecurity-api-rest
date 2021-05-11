package com.bitcollege.knowledgecybersecuritywebservice.service;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Tool;

import java.util.List;

public interface ToolService {
    public List<Tool> findByKnowledgeUnitId(Long knowledgeUnitId);
}
