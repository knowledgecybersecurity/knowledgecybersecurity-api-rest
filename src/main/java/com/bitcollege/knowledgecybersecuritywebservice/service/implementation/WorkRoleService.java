package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.WorkRoleRepository;
import com.bitcollege.knowledgecybersecuritywebservice.entity.WorkRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRoleService implements com.bitcollege.knowledgecybersecuritywebservice.service.WorkRoleService {

    @Autowired
    private WorkRoleRepository workRoleRepository;

    @Override
    public List<WorkRole> findByKnowledgeUnitId(Long knowledgeUnitId) {
        return workRoleRepository.findByKnowledgeUnitId(knowledgeUnitId);
    }
}
