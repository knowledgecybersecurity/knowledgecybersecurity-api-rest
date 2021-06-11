package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface IPublicationRepository extends JpaRepository<Publication, Long> {
//    List<Publication> findAllByPrice(double price, Pageable pageable);
}
