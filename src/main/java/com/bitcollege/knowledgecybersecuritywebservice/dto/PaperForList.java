package com.bitcollege.knowledgecybersecuritywebservice.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaperForList {
    private Long id;
    private String title;
    private String year;
    private String sourceTitle;
    private String link;
    private String paperAbstract;
    private String doi;
    private String authors;
    private String authorKeyword;
    private String source;
    private String documentType;
    private Boolean isFavoriteForThisUser;
}
