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
public class Publication {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition="TEXT")
    private String firstParagraph;

    @Column(nullable = true)
    private String imageUrl;

    //mapeando many-to-one
    private Long idUser;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
    //

    @JsonIgnore
    @OneToMany(mappedBy = "publication", fetch = FetchType.EAGER)
    private List<SectionPublication> sectionPublications;
}
