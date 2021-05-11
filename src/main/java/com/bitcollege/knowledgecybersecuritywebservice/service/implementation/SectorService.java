package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.SectorRepository;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorService implements com.bitcollege.knowledgecybersecuritywebservice.service.SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public List<Sector> findByKnowledgeUnitId(Long knowledgeUnitId) {
        return sectorRepository.findByKnowledgeUnitId(knowledgeUnitId);
    }
}
