package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.KeywordRepository;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class KeywordService implements com.bitcollege.knowledgecybersecuritywebservice.service.KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;

    @Override
    public List<Keyword> findTop4ByKnowledgeUnitIdAndSectorId(Long knowledgeUnitId, Long sectorId) {
        List<Map<String, Object>> objects = keywordRepository.findTop4ByKnowledgeUnitIdAndSectorId(knowledgeUnitId, sectorId);
        List<Keyword> keywords = new ArrayList<>();

        for(int i = 0; i < objects.size(); i++){
            Keyword aux = new Keyword();
            BigInteger tempId = (BigInteger) objects.get(i).get("id");
            aux.setId((tempId.longValue()));
            aux.setName((String) objects.get(i).get("name"));
            keywords.add(aux);
        }
        return keywords;
    }
}
