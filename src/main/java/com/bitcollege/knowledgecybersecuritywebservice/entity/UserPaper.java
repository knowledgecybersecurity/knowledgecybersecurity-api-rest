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
public class UserPaper {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long idPaper;

    private Long idUser;


    @ManyToOne
    @JoinColumn(name = "idPaper", referencedColumnName = "id", insertable = false, updatable = false)
    private Paper paper;

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
}
