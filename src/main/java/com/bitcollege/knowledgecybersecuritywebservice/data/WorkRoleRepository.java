package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.WorkRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkRoleRepository extends JpaRepository<WorkRole, Long> {

    @Query(value = "select *\n" +
            "from work_role wr\n" +
            "join ku_wr kuwr on kuwr.fk_work_role = wr.id\n" +
            "where kuwr.fk_knowledge_unit =  ?1", nativeQuery = true)
    public List<WorkRole> findByKnowledgeUnitId(Long knowledgeUnitId);
}
