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
public class PublicationUpdateDTO {

    private Long id;

    private String title;

    private String firstParagraph;

    private String imageUrl;

    private Long idUser;

    private List<SectionPublication> sectionPublications;
}
