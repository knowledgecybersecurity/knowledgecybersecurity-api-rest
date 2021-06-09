package com.bitcollege.knowledgecybersecuritywebservice.service;

import com.bitcollege.knowledgecybersecuritywebservice.dto.PublicationDTO;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Publication;

import java.util.List;

public interface IPublicationService {

    Publication create(PublicationDTO publicationDTO) throws Exception;

    Publication update(PublicationDTO publicationDTO) throws Exception;

    List<Publication> list() throws Exception;

    Publication findById(Long id) throws Exception;

}
