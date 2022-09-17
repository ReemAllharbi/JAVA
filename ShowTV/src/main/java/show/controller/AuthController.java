package show.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import show.models.User;
import show.request.UserLoginRequest;
import show.services.UserService;

@Controller
public class AuthController {

		private final UserService userService;
		//private final TVShowService tvshowService;

		
		
		public AuthController(UserService userService) {
			this.userService = userService;
			//sthis.tvshowService = tvshowService;
		}

		
		@GetMapping("/")
		public String createUserView(Model model) {
			if(!model.containsAttribute("newUser")) {
				model.addAttribute("newUser", new User());			
			}
			if(!model.containsAttribute("userLoginRequest")) {
				model.addAttribute("userLoginRequest", new UserLoginRequest());			
			}
			return "index.jsp";
		}
		
		@PostMapping("/register")
		public String createUserAction(
				@Valid @ModelAttribute("newUser") User newUser,
				BindingResult result,
				RedirectAttributes redirectAttributes,
				HttpSession session
				) {
			User user = userService.createUser(newUser, result);
			if(user == null) {
				redirectAttributes.addFlashAttribute("newUser", newUser);
				redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newUser", result);
				return "redirect:/";
			} else {
				session.setAttribute("user_id", user.getId());
				return "redirect:/tvshows";
			}
		}
		
		@PostMapping("/login")
		public String loginUser(
				@Valid @ModelAttribute("userLoginRequest") UserLoginRequest userLoginRequest,
				BindingResult result,
				RedirectAttributes redirectAttributes,
				HttpSession session,
				Model  model
				) {
			if(result.hasErrors()) {
				System.out.println("Running into errors validation #1");
				redirectAttributes.addFlashAttribute("userLoginRequest", userLoginRequest);
				redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginRequest", result);
				return "redirect:/";
			}
			
			User user = userService.loginUser(userLoginRequest, result);
			if(user == null) {
				System.out.println("Running into errors validation #2");
				redirectAttributes.addFlashAttribute("userLoginRequest", userLoginRequest);
				redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginRequest", result);
				return "redirect:/";
			} else {
				session.setAttribute("user_id", user.getId());
				session.setAttribute("name", user.getName());
			
				return "redirect:/tvshows";
			}
			
		}
		
//		public String login
		
	
		
		@GetMapping("/logout")
		public String index(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		
		
		
	}



