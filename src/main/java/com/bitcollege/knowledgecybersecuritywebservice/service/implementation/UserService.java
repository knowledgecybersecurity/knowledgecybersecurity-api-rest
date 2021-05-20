package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcollege.knowledgecybersecuritywebservice.data.IUserRepository;
import com.bitcollege.knowledgecybersecuritywebservice.dto.CreateUserDTO;
import com.bitcollege.knowledgecybersecuritywebservice.dto.GetUserDTO;
import com.bitcollege.knowledgecybersecuritywebservice.entity.User;
import com.bitcollege.knowledgecybersecuritywebservice.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public GetUserDTO create(CreateUserDTO userToCreateDTO) throws Exception {
		
		User userFindedByEmail = this.userRepo.findByEmail(userToCreateDTO.getEmail());
		
		if (userFindedByEmail != null) {
			throw new Exception("Duplicate email"); 
		}
		
		User userToCreate = modelMapper.map(userToCreateDTO, User.class);
		
		User userInDB = this.userRepo.save(userToCreate);
		
		GetUserDTO userinDbDTO = this.modelMapper.map(userInDB, GetUserDTO.class);
		
		return userinDbDTO;
	}

	@Override
	public GetUserDTO update(GetUserDTO userToUpdateDTO) throws Exception {
		User userToUpdate = this.modelMapper.map(userToUpdateDTO, User.class);
		
		User userUpdatedInDb = this.userRepo.save(userToUpdate);
		
		GetUserDTO userinDbDTO = this.modelMapper.map(userUpdatedInDb, GetUserDTO.class);
		
		return userinDbDTO;
	}

	@Override
	public List<GetUserDTO> list() throws Exception {
		List<User> usersInDb = this.userRepo.findAll();
		
		List<GetUserDTO> usersToSend = usersInDb.stream().map(user -> this.modelMapper.map(user, GetUserDTO.class)).collect(Collectors.toList());

		return usersToSend;
	}

	@Override
	public GetUserDTO getUserById(Long id) throws Exception {
		User userFinded = this.userRepo.findById(id).orElse(null);
		
		if (userFinded == null) {
			return null;
		}
		
		GetUserDTO userFindedDTO = this.modelMapper.map(userFinded, GetUserDTO.class);
		
		return userFindedDTO;
	}

}
