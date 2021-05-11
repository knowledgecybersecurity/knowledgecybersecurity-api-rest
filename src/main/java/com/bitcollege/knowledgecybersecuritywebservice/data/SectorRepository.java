package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SectorRepository extends JpaRepository<Sector, Long> {

    @Query(value = "select distinct s.id, s.name\n" +
            "from sector s\n" +
            "join paper p on p.sector_id = s.id\n" +
            "join ku_paper kup on kup.fk_paper = p.id\n" +
            "join knowledge_unit ku on ku.id = kup.fk_knowledge_unit\n" +
            "where ku.id = ?1", nativeQuery = true)
    public List<Sector> findByKnowledgeUnitId(Long knowledgeUnitId);
}
