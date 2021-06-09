package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublicationRepository extends JpaRepository<Publication, Long> {
}
