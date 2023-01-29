package kodlama.northwind.payload.response;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
public class JwtResponse {
	
	private String token;
	private String type = "Bearer";
	@JsonIgnore
	private Long id;
	@JsonIgnore
	private String username;
	@JsonIgnore
	private String email;
	@JsonIgnore
	private List<String> roles;

	
	public JwtResponse(String token, Long id, String username, String email, List<String> roles) {
		super();
		this.token = token;
		//this.type = type;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
	public JwtResponse( Long id, String username, String email, List<String> roles) {
		
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public List<String> getRoles() {
		return roles;
	}




	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	
	

	

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	
}
