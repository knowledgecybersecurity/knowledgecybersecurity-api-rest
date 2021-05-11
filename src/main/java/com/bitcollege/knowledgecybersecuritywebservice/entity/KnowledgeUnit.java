package com.bitcollege.knowledgecybersecuritywebservice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
public class KnowledgeUnit {

    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 800)
    private String definition;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private KnowledgeArea knowledgeArea;

    @JsonIgnore
    @JoinTable(
            name = "ku_paper",
            joinColumns = @JoinColumn(name = "fk_knowledge_unit", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_paper", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Paper> papers;

    @JsonIgnore
    @JoinTable(
            name = "ku_certificate",
            joinColumns = @JoinColumn(name = "fk_knowledge_unit", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_certificate", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Certificate> certificates;

    @JsonIgnore
    @JoinTable(
            name = "ku_congress",
            joinColumns = @JoinColumn(name = "fk_knowledge_unit", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_congress", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Congress> congresses;

    @JsonIgnore
    @JoinTable(
            name = "ku_wr",
            joinColumns = @JoinColumn(name = "fk_knowledge_unit", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_work_role", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<WorkRole> workRoles;
}