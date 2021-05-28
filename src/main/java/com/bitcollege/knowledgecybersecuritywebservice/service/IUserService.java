package com.bitcollege.knowledgecybersecuritywebservice.service;

import java.util.List;

import com.bitcollege.knowledgecybersecuritywebservice.dto.CreateUserDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.GetUserDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.LoginResponse;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Paper;
import com.bitcollege.knowledgecybersecuritywebservice.entity.UserPaper;

public interface IUserService {
	
	public GetUserDTO create(CreateUserDTO userToCreate) throws Exception;
	
	public GetUserDTO update(GetUserDTO userToUpdate) throws Exception;
	
	public List<GetUserDTO> list() throws Exception;
	
	public GetUserDTO getUserById(Long id) throws Exception;
	
	public LoginResponse login(String email, String password) throws Exception;

	public UserPaper addFavoritePaper(Long idUser, Long idPaper) throws Exception;

	public List<Paper> listUserFavoritePapers(Long idUser) throws Exception;
}
