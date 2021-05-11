package com.bitcollege.knowledgecybersecuritywebservice.controller;

import com.bitcollege.knowledgecybersecuritywebservice.entity.WorkRole;
import com.bitcollege.knowledgecybersecuritywebservice.service.WorkRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkRoleController {
    @Autowired
    private WorkRoleService workRoleService;

    @GetMapping("/knowledge-units/{kuId}/work-roles")
    public List<WorkRole> findByKnowledgeUnit(@PathVariable Long kuId){
        return workRoleService.findByKnowledgeUnitId(kuId);
    }
}
