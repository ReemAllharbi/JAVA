package show.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import show.models.Tvshow;
import show.models.User;
import show.services.TVshowService;
import show.services.UserService;

@Controller
public class TVshowController {
	private final TVshowService tvshowService;
	private final UserService userService;


	public TVshowController(TVshowService tvshowService, UserService userService) {
		this.tvshowService = tvshowService;
		this.userService = userService;


	}
	@GetMapping("/tvshows")
	public String home(Model model,HttpSession session, RedirectAttributes redirectAttributes) { 
		
		if(session.getAttribute("user_id") == null) {
			redirectAttributes.addFlashAttribute("error", "you need to login/register first");
			return "redirect:/";
		}
		if (!model.containsAttribute("tvshow")) {
			model.addAttribute("tvshow",new Tvshow());
		}
		Long id= (Long) session.getAttribute("user_id");
		User user = userService.findUser(id);
		model.addAttribute("user",user);
		
		List<Tvshow> tvshows = tvshowService.allTvshow();
		model.addAttribute("tvshows",tvshows);
		return "tvshows.jsp";
		
	}
	
	  @RequestMapping(value="/new", method=RequestMethod.GET)
	    public String newtvshow(Model model,@ModelAttribute("tvshow") Tvshow tvshow) {
	    	
	
	    	
	        return "add_show.jsp";
	    }
	  //Add
	    @RequestMapping(value="/new", method=RequestMethod.POST)
	    public String create(@Valid@ModelAttribute("tvshow") Tvshow tvshow,
	    	   BindingResult result,
	    		RedirectAttributes redirectAttributes,
				HttpSession session
				) {
	    	if (result.hasErrors()) {
				redirectAttributes.addFlashAttribute("tvshow",tvshow);
				redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.tvshow",result);
				return "redirect:/new";
			} 
					
			Long id= (Long) session.getAttribute("user_id");
			User user = userService.findUser(id);
			// user created event
			tvshow.setUsers(user);
	
			
			tvshowService.createTvshow(tvshow);
			redirectAttributes.addFlashAttribute("success", "TV Show was created successfully");
			return "redirect:/tvshows";				        
	    }
	    
	    //view
	    
		@GetMapping("/tvshows/{id}")
		public String viewTVShow (@PathVariable(value="id") Long id,Model model) {
			Tvshow tvshow = tvshowService.findTvshow(id);
	
			model.addAttribute("tvshow",tvshow);
			return "view.jsp";
		}
		
		//Edit
		
		@PutMapping(value="/update/{id}")
		public String update(@PathVariable("id") Long id,
				@Valid @ModelAttribute("tvshow") Tvshow tvshow , 
				BindingResult result, RedirectAttributes redirectAttributes, HttpSession session) {
			if (result.hasErrors()) {
				redirectAttributes.addFlashAttribute("tvshow",tvshow);
				redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.tvshow",result);
				
				return "redirect:/tvshows/"+tvshow.getId();
			}

			Long user_id=(Long) session.getAttribute("user_id");
			User user = userService.findUser(user_id);
			tvshow.setUsers(user);
			tvshowService.updateTvshow(id,tvshow);
			redirectAttributes.addFlashAttribute("success", "Tvshow was edited successfully");
			
			return "redirect:/tvshows/"+tvshow.getId();
			}
		
		//delete
	
		@DeleteMapping("/tvshows/{id}/delete")
		public String deleteEvent(@PathVariable(value="id") Long id) {
			tvshowService.deleteTvshow(id);
			return "redirect:/tvshows";
		}
}
	