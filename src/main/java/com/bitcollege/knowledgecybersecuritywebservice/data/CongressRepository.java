package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Congress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CongressRepository extends JpaRepository<Congress, Long> {

    @Query(value = "select * from congress c\n" +
            "join ku_congress ku_c on ku_c.fk_congress = c.id\n" +
            "where ku_c.fk_knowledge_unit = ?1", nativeQuery = true)
    public List<Congress> findByKnowledgeUnitId(Long knowledgeUnitId);
}
