package com.bitcollege.knowledgecybersecuritywebservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDTO {
	
	private Long id;
	
	private String firstName;
    
    private String lastName;
    
    private String email;
        
    private Integer age;
    
    private String country;
    
    private String address;

}
