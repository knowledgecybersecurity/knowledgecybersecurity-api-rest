package com.bitcollege.knowledgecybersecuritywebservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paper {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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


    @JsonIgnore
    @ManyToMany(mappedBy = "papers")
    private List<KnowledgeUnit> knowledgeUnits;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private KnowledgeObjective knowledgeObjective;

    @JsonIgnore
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Sector sector;

    @JsonIgnore
    @JoinTable(
            name = "paper_keyword",
            joinColumns = @JoinColumn(name = "fk_paper", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_keyword", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Keyword> keywords;
}