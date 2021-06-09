package com.bitcollege.knowledgecybersecuritywebservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SectionPublication {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String subtitle;

    @Column(columnDefinition="TEXT")
    private String paragraph;

    @Column(nullable = true)
    private String imageUrl;

    //mapeando many-to-one
    private Long idPublication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPublication", referencedColumnName = "id", insertable = false, updatable = false)
    private Publication publication;
    //

}
