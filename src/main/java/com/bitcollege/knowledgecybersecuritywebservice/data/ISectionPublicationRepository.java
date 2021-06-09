package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.SectionPublication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionPublicationRepository extends JpaRepository<SectionPublication, Long> {
}
