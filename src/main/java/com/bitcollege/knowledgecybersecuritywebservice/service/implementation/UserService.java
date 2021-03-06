package com.bitcollege.knowledgecybersecuritywebservice.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.bitcollege.knowledgecybersecuritywebservice.data.IUserPaperRepository;
import com.bitcollege.knowledgecybersecuritywebservice.dto.*;
import com.bitcollege.knowledgecybersecuritywebservice.entity.Paper;
import com.bitcollege.knowledgecybersecuritywebservice.entity.UserPaper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitcollege.knowledgecybersecuritywebservice.data.IUserRepository;
import com.bitcollege.knowledgecybersecuritywebservice.entity.User;
import com.bitcollege.knowledgecybersecuritywebservice.service.IUserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private IUserPaperRepository userPaperRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;

	@Override
	public GetUserDTO create(CreateUserDTO userToCreateDTO) throws Exception {
		
		User userFindedByEmail = this.userRepo.findByEmail(userToCreateDTO.getEmail());
		
		if (userFindedByEmail != null) {
			throw new Exception("Duplicate email"); 
		}
		
		if (userToCreateDTO.getPassword() == null || userToCreateDTO.getEmail() == null) {
			throw new Exception("No estan las credenciales"); 
		}
		
		String encodePassword = this.bCrypt.encode(userToCreateDTO.getPassword());
		
		userToCreateDTO.setPassword(encodePassword);
		
		User userToCreate = modelMapper.map(userToCreateDTO, User.class);
		
		userToCreate.setRol("ROLE_USER");
		
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
	
	private String getJWTToken(User user) {
		String secretKey = "mySecretKey";
		
		List<GrantedAuthority> grantedAuthorities = null;
		
		if (user.getRol().equals("ROLE_ADMIN")) {
			grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_USER, ROLE_ADMIN");
		}
		
		if (user.getRol().equals("ROLE_USER")) {
			grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_USER");
		}
		
		Long objectId = user.getId();
		
		String token = Jwts
				.builder()
				.setId(objectId.toString())
				.setSubject(user.getEmail())
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	@Override
	public LoginResponse login(String email, String password) throws Exception {
		User userFinded = this.userRepo.findByEmail(email);
		
		if (userFinded == null) {
			throw new Exception("No existe cuenta");
		}
		
		Boolean matchPassword = this.bCrypt.matches(password, userFinded.getPassword());
		
		if (matchPassword) {
			LoginResponse loginReponse = new LoginResponse();
			
			loginReponse.setUser(this.modelMapper.map(userFinded, GetUserDTO.class));
			
			String tokenGenerated = this.getJWTToken(userFinded);
			
			loginReponse.setToken(tokenGenerated);
					
			return loginReponse;
		} else {
			throw new Exception("No existe cuenta");
		}
	}

	@Override
	public UserPaper addFavoritePaper(Long idUser, Long idPaper) throws Exception {
		UserPaper userPaper = new UserPaper();
		userPaper.setIdPaper(idPaper);
		userPaper.setIdUser(idUser);

		UserPaper userpaperCreated = this.userPaperRepository.save(userPaper);
		return userpaperCreated;
	}

	@Override
	public Boolean removeFavoritePaper(Long idUser, Long idPaper) throws Exception {
		List<UserPaper> userPapersToRemove = this.userPaperRepository.findByIdUserAndIdPaper(idUser, idPaper);
		this.userPaperRepository.deleteAll(userPapersToRemove);
		return true;
	}

	@Override
	public InitResetPasswordResponseDTO initResetPassword(String email) throws Exception {
		User userInDb = this.userRepo.findByEmail(email);
		InitResetPasswordResponseDTO userInitResetPasswordResponseDTO = this.modelMapper.map(userInDb, InitResetPasswordResponseDTO.class);
		return userInitResetPasswordResponseDTO;
	}

	@Override
	public ResetPasswordRequestDTO resetPassword(ResetPasswordRequestDTO resetPasswordRequestDTO) throws Exception {
		String email = resetPasswordRequestDTO.getEmail();
		User userInDb = this.userRepo.findByEmail(email);

		if(userInDb == null) {
			throw new Exception("User doesn't exists");
		}

		if (resetPasswordRequestDTO.getSecretAnswer().equals(userInDb.getSecretAnswer())
		&& resetPasswordRequestDTO.getSecretQuestion().equals(userInDb.getSecretQuestion())
		) {
			String encodePassword = this.bCrypt.encode(resetPasswordRequestDTO.getPassword());
			userInDb.setPassword(encodePassword);
			this.userRepo.save(userInDb);
			return resetPasswordRequestDTO;
		} else {
			throw new Exception("Error at match");
		}
	}

	@Override
	public List<Paper> listUserFavoritePapers(Long idUser) throws Exception {
		List<UserPaper> userPapers = this.userPaperRepository.findByIdUser(idUser);
		List<Paper> papers = userPapers.stream().map(x -> x.getPaper()).collect(Collectors.toList());
		return papers;
	}

}
