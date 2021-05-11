package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface KeywordRepository extends JpaRepository<Certificate, Long> {


    @Query(value = "select \n" +
            " k.id, k.name\n" +
            "from \n" +
            "keyword k\n" +
            "join paper_keyword p_k on p_k.fk_keyword = k.id\n" +
            "join paper p on p_k.fk_paper = p.id\n" +
            "join ku_paper kup on kup.fk_paper = p.id\n" +
            "join knowledge_unit ku on ku.id = kup.fk_knowledge_unit\n" +
            "where \n" +
            "p.sector_id = ?2\n" +
            "and ku.id = ?1\n" +
            "group by k.id, p_k.fk_keyword\n" +
            "order by count(*) desc\n" +
            "limit 4", nativeQuery = true)
    public List<Map<String, Object >> findTop4ByKnowledgeUnitIdAndSectorId(Long knowledgeUnitId, Long sectorId);
}
