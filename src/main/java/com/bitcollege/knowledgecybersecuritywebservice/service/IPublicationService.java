package com.bitcollege.knowledgecybersecuritywebservice.service;

import com.bitcollege.knowledgecybersecuritywebservice.dto.PublicationDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.PublicationPageDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.PublicationUpdateDTO;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Publication;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPublicationService {

    Publication create(PublicationDTO publicationDTO) throws Exception;

    Publication update(PublicationUpdateDTO publicationUpdateDTO, Long idPublication) throws Exception;

    Publication aprobe(Long idPublication) throws Exception;

    List<Publication> list() throws Exception;

    Page<PublicationPageDTO> listPagination(Integer pageNumber, Integer size) throws Exception;

    Page<PublicationPageDTO> listPaginationForUserId(Integer pageNumber, Integer size, Long id) throws Exception;

    Page<PublicationPageDTO> listPaginationNotAprovved(Integer pageNumber, Integer size) throws Exception;

    Publication findById(Long id) throws Exception;

}
