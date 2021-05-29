package com.bitcollege.knowledgecybersecuritywebservice.data;

import com.bitcollege.knowledgecybersecuritywebservice.entity.UserPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserPaperRepository  extends JpaRepository<UserPaper, Long> {

    List<UserPaper> findByIdUser(Long idUser);

    List<UserPaper> findByIdUserAndIdPaper(Long idUser, Long idPaper);

}
