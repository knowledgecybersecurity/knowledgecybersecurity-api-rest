package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublicationRepository extends JpaRepository<Publication, Long> {
    Page<Publication> findByUser_Id(final Long id, Pageable pageable);
    Page<Publication> findByisApprove(final Boolean isApprove, Pageable pageable);


}
