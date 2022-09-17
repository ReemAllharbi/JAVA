package show.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserLoginRequest {
	@NotEmpty
	@Email(message="Email cannot be blank")
	private String email;
	
	@NotEmpty
	@Size(min=8,max=128,message="password needs to be between 8-128 characters")
	private String password;
	
	public UserLoginRequest() {
		//
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
