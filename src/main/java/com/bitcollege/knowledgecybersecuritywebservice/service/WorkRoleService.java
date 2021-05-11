package com.bitcollege.knowledgecybersecuritywebservice.service;

import com.bitcollege.knowledgecybersecuritywebservice.entity.WorkRole;

import java.util.List;

public interface WorkRoleService {
    public List<WorkRole> findByKnowledgeUnitId(Long knowledgeUnitId);
}
