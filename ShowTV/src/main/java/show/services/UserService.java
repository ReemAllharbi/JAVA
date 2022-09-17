package show.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import show.models.User;
import show.repositories.UserRepository;
import show.request.UserLoginRequest;

@Service
	public class UserService {
		
		private final UserRepository userRepo;
		
		
		public UserService(UserRepository userRepo) {
			this.userRepo=userRepo;
		}
		
		public User createUser(User user, BindingResult bindingResult) {
			Optional<User> userOptional = userRepo.findByEmail(user.getEmail());
			if(userOptional.isPresent()) {
				bindingResult.rejectValue("email", "unique", "Email address already exist");
			}
			
			if(!user.getPassword().equals(user.getConfirmPassword())) {
				bindingResult.rejectValue("password", "matches", "Passwords do not match");
			}
			
			
			if(bindingResult.hasErrors()) {
				return null;
			} else {
				String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
				user.setPassword(hashed);
				return userRepo.save(user);
			}
		}
		

		public User loginUser(UserLoginRequest userLoginRequest, BindingResult result) {
			Optional<User> optionalUser = userRepo.findByEmail(userLoginRequest.getEmail());
			if(!optionalUser.isPresent()) {
				result.rejectValue("email", "exists", "Email address does not exist.");
			} else {
				User user = optionalUser.get();
				if(BCrypt.checkpw(userLoginRequest.getPassword(), user.getPassword())) {
					return user;
				} else {
					result.rejectValue("password", "Invalid", "Invalid password.");
				}
			}
			return null;
		}
		public User findUser(Long id) {
			Optional<User> optionalUser =  userRepo.findById(id);
		    return optionalUser.isPresent()?  optionalUser.get() : null;
		}

	}


