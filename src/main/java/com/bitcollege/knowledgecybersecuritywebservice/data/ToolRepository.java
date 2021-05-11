package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToolRepository extends JpaRepository<Tool, Long> {

    /*
    @Query(value = "select * from tool t\n" +
            "join ku_certificate ku_c on ku_c.fk_certificate = c.id\n" +
            "where ku_c.fk_knowledge_unit = ?1", nativeQuery = true)
    public List<Certificate> findByKnowledgeUnitId(Long knowledgeUnitId);
     */

    public List<Tool> findByKnowledgeUnit_Id(Long knowledgeUnitId);
}
