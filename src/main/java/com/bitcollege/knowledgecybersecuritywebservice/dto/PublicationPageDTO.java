package com.bitcollege.knowledgecybersecuritywebservice.dto;

import com.bitcollege.knowledgecybersecuritywebservice.entity.SectionPublication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationPageDTO {
    private Long id;

    private String title;

    private String firstParagraph;

    private String imageUrl;

    private Long idUser;

    private GetUserDTO userDTO;

    private List<SectionPublication> sectionPublications;
}
