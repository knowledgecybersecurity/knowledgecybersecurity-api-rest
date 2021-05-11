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
public class WorkRole {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "workRoles")
    private List<KnowledgeUnit> knowledgeUnits;

    @JsonIgnore
    @JoinTable(
            name = "wr_ksat",
            //TODO change column name
            //joinColumns = @JoinColumn(name = "fk_work_role", nullable = false),
            joinColumns = @JoinColumn(name = "fk_knowledge_unit", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_ksat", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ksat> ksats;


}