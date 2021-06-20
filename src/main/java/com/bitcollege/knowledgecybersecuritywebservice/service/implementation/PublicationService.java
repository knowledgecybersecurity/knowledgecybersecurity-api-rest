package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.IPublicationRepository;
import com.bitcollege.knowledgecybersecuritywebservice.data.ISectionPublicationRepository;
import com.bitcollege.knowledgecybersecuritywebservice.dto.GetUserDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.PublicationDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.PublicationPageDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.PublicationUpdateDTO;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Publication;
import com.bitcollege.knowledgecybersecuritywebservice.entity.SectionPublication;
import com.bitcollege.knowledgecybersecuritywebservice.service.IPublicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService implements IPublicationService {

    @Autowired
    private IPublicationRepository publicationRepository;

    @Autowired
    private ISectionPublicationRepository sectionPublicationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Publication create(PublicationDTO publicationDTO) throws Exception {

        Publication publicationToSave = this.modelMapper.map(publicationDTO, Publication.class);
        publicationToSave.setId(null);

        publicationToSave.setIsApprove(false);

        Publication publication = this.publicationRepository.save(publicationToSave);

        List<SectionPublication> sectionPublicationList = publicationDTO.getSectionPublications().stream().map(x-> {
            x.setIdPublication(publicationToSave.getId());
            return x;
        }).collect(Collectors.toList());

        this.sectionPublicationRepository.saveAll(sectionPublicationList);

        return publication;
    }

    @Override
    @Transactional
    public Publication update(PublicationUpdateDTO publicationUpdateDTO, Long idPublication) throws Exception {
        Publication publicationToUpdate = this.modelMapper.map(publicationUpdateDTO, Publication.class);
        //this.sectionPublicationRepository
        Publication pubCreated = this.publicationRepository.save(publicationToUpdate);
        List<SectionPublication> sectionsToUpdate = pubCreated.getSectionPublications().stream().map(section ->{
            section.setIdPublication(idPublication);
            return section;
        }).collect(Collectors.toList());
        this.sectionPublicationRepository.saveAll(sectionsToUpdate);
        return publicationToUpdate;
    }

    @Override
    public Publication aprobe(Long idPublication) throws Exception {
        Publication publicationToEdit = this.publicationRepository.findById(idPublication).orElse(null);
        if(publicationToEdit == null) {
            throw new Exception("Publication doesn't exists");
        }
        publicationToEdit.setIsApprove(true);
        Publication publicationSaved = this.publicationRepository.save(publicationToEdit);
        return publicationSaved;
    }


    @Override
    public List<Publication> list() throws Exception {
        return this.publicationRepository.findAll();
    }

    @Override
    public Page<PublicationPageDTO> listPagination(Integer pageNumber, Integer size) throws Exception {
        size = (size > 20) ? 20 : size;

        Pageable pageFiltered = PageRequest.of(pageNumber, size, Sort.by("id").descending());

        //Page<Publication> publicationsFinded = this.publicationRepository.findAll(pageFiltered);
        Page<Publication> publicationsFinded = this.publicationRepository.findByisApprove(true, pageFiltered);

        Page<PublicationPageDTO>  publicationsFindedDTO= publicationsFinded.map(pagePublication -> {
            PublicationPageDTO publicationPageDTO = this.modelMapper.map(pagePublication, PublicationPageDTO.class);
            publicationPageDTO.setUserDTO(this.modelMapper.map(pagePublication.getUser(), GetUserDTO.class));
            return publicationPageDTO;
        });

        return publicationsFindedDTO;
    }

    @Override
    public Page<PublicationPageDTO> listPaginationNotAprovved(Integer pageNumber, Integer size) throws Exception {
        size = (size > 20) ? 20 : size;

        Pageable pageFiltered = PageRequest.of(pageNumber, size, Sort.by("id").descending());

        //Page<Publication> publicationsFinded = this.publicationRepository.findAll(pageFiltered);
        Page<Publication> publicationsFinded = this.publicationRepository.findByisApprove(false, pageFiltered);

        Page<PublicationPageDTO>  publicationsFindedDTO= publicationsFinded.map(pagePublication -> {
            PublicationPageDTO publicationPageDTO = this.modelMapper.map(pagePublication, PublicationPageDTO.class);
            publicationPageDTO.setUserDTO(this.modelMapper.map(pagePublication.getUser(), GetUserDTO.class));
            return publicationPageDTO;
        });

        return publicationsFindedDTO;
    }

    @Override
    public Page<PublicationPageDTO> listPaginationForUserId(Integer pageNumber, Integer size, Long id) throws Exception {
        size = (size > 20) ? 20 : size;

        Pageable pageFiltered = PageRequest.of(pageNumber, size, Sort.by("id").descending());

        Page<Publication> publicationsFinded = this.publicationRepository.findByUser_Id(id, pageFiltered);

        Page<PublicationPageDTO>  publicationsFindedDTO= publicationsFinded.map(pagePublication -> {
            PublicationPageDTO publicationPageDTO = this.modelMapper.map(pagePublication, PublicationPageDTO.class);
            publicationPageDTO.setUserDTO(this.modelMapper.map(pagePublication.getUser(), GetUserDTO.class));
            return publicationPageDTO;
        });

        return publicationsFindedDTO;
    }

    @Override
    public Publication findById(Long id) throws Exception {
        return this.publicationRepository.findById(id).orElse(null);
    }
}
