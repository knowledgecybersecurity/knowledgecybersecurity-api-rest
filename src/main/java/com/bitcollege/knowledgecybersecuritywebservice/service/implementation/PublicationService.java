package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import com.bitcollege.knowledgecybersecuritywebservice.data.IPublicationRepository;
import com.bitcollege.knowledgecybersecuritywebservice.data.ISectionPublicationRepository;
import com.bitcollege.knowledgecybersecuritywebservice.dto.PublicationDTO;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Publication;
import com.bitcollege.knowledgecybersecuritywebservice.entity.SectionPublication;
import com.bitcollege.knowledgecybersecuritywebservice.service.IPublicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Publication publication = this.publicationRepository.save(publicationToSave);

        List<SectionPublication> sectionPublicationList = publicationDTO.getSectionPublications().stream().map(x-> {
            x.setIdPublication(publicationToSave.getId());
            return x;
        }).collect(Collectors.toList());

        this.sectionPublicationRepository.saveAll(sectionPublicationList);

        return publication;
    }

    @Override
    public Publication update(PublicationDTO publicationDTO) throws Exception {
        Publication publicationToUpdate = this.modelMapper.map(publicationDTO, Publication.class);
        return this.publicationRepository.save(publicationToUpdate);
    }

    @Override
    public List<Publication> list() throws Exception {
        return this.publicationRepository.findAll();
    }

    @Override
    public Publication findById(Long id) throws Exception {
        return this.publicationRepository.findById(id).orElse(null);
    }
}
