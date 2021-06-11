package com.bitcollege.knowledgecybersecuritywebservice.service;

import com.bitcollege.knowledgecybersecuritywebservice.dto.PublicationDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.PublicationPageDTO;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Publication;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPublicationService {

    Publication create(PublicationDTO publicationDTO) throws Exception;

    Publication update(PublicationDTO publicationDTO) throws Exception;

    List<Publication> list() throws Exception;

    Page<PublicationPageDTO> listPagination(Integer pageNumber, Integer size) throws Exception;

    Publication findById(Long id) throws Exception;

}
