package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.ToolRepository;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolService implements com.bitcollege.knowledgecybersecuritywebservice.service.ToolService {

    @Autowired
    private ToolRepository toolRepository;

    @Override
    public List<Tool> findByKnowledgeUnitId(Long knowledgeUnitId) {
        return toolRepository.findByKnowledgeUnit_Id(knowledgeUnitId);
    }
}
