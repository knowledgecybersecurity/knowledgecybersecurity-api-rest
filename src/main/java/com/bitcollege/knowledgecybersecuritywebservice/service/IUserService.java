package com.bitcollege.knowledgecybersecuritywebservice.service;

import java.util.List;

import com.bitcollege.knowledgecybersecuritywebservice.dto.CreateUserDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.GetUserDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.LoginResponse;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Paper;
import com.bitcollege.knowledgecybersecuritywebservice.entity.UserPaper;

public interface IUserService {
	
	GetUserDTO create(CreateUserDTO userToCreate) throws Exception;
	
	GetUserDTO update(GetUserDTO userToUpdate) throws Exception;
	
	List<GetUserDTO> list() throws Exception;
	
	GetUserDTO getUserById(Long id) throws Exception;
	
	LoginResponse login(String email, String password) throws Exception;

	UserPaper addFavoritePaper(Long idUser, Long idPaper) throws Exception;

	List<Paper> listUserFavoritePapers(Long idUser) throws Exception;

	Boolean removeFavoritePaper(Long idUser, Long idPaper) throws Exception;
}
