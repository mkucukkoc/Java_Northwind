package kodlama.northwind.payload.response;

import java.util.*;
public class JwtResponse {
	
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private List<String> roles;

	
	public JwtResponse(String accessToken) {
		this.token = accessToken;
		
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
