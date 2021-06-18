package com.bitcollege.knowledgecybersecuritywebservice.entity;

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

    @Column(columnDefinition = "boolean default false", nullable = true, updatable = true, insertable = true)
    private Boolean isApprove;

    @Column(nullable = true)
    private String imageUrl;

    //mapeando many-to-one
    private Long idUser;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
    //

    @OneToMany(mappedBy = "publication", fetch = FetchType.LAZY)
    private List<SectionPublication> sectionPublications;
}
