package com.bitcollege.knowledgecybersecuritywebservice.service;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Congress;

import java.util.List;

public interface CongressService {
    public List<Congress> findByKnowledgeUnitId(Long knowledgeUnitId);
}
