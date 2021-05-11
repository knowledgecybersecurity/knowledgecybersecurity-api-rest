package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.KnowledgeObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface KnowledgeObjectiveRepository extends JpaRepository<KnowledgeObjective, Long> {

    @Query(value = "select k_o.id, k_o.name, SQ.paper_amount\n" +
            "from knowledge_objective k_o \n" +
            "left join\n" +
            "(select\n" +
            "ko.id as 'id', ko.name, count(*) as 'paper_amount'\n" +
            "from knowledge_objective ko\n" +
            "left join paper p on p.knowledge_objective_id = ko.id\n" +
            "left join ku_paper kup on kup.fk_paper = p.id\n" +
            "left join knowledge_unit ku on ku.id = kup.fk_knowledge_unit\n" +
            "where \n" +
            "p.sector_id = ?2\n" +
            "and ku.id = ?1\n" +
            "group by ko.id, ko.name) \n" +
            "as SQ\n" +
            "on k_o.id = SQ.id;", nativeQuery = true)
    public List<Map<String, Object >> findByKnowledgeUnitIdAndSectorId(Long knowledgeUnitId, Long sectorId);
}
