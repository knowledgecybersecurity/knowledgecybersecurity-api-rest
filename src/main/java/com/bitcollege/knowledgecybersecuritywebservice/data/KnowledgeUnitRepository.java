package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.KnowledgeUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeUnitRepository extends JpaRepository<KnowledgeUnit, Long> {
}
