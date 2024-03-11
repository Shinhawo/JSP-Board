package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.AuthVo;
import org.zerock.domain.MemberJoinForm;
import org.zerock.domain.MemberVo;
import org.zerock.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class CommonController {

	private UserService service;
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		
		model.addAttribute("msg", "Access Denied");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		
		log.info("error : " + error);
		log.info("logout : " + logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGet() {
		log.info("custom logout");
	}
	

	@GetMapping("/userRegister")
	public void register(Model model) {
		MemberJoinForm form = new MemberJoinForm();
		model.addAttribute("member", form);
	}
	
	@PostMapping("/userRegister")
	public String registerAction(@ModelAttribute("member") MemberJoinForm form,  SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {
		
		MemberVo vo = MemberVo.builder()
				.userid(form.getUserid())
				.userpw(form.getUserpw())
				.userEmail(form.getUserEmail())
				.userName(form.getUserName())
				.build();
		
		AuthVo auth = new AuthVo();
		auth.setAuth("ROLE_USER");
		auth.setUserid(form.getUserid());
		
		service.insertUser(vo);
		service.insertRole(auth);
		
		sessionStatus.setComplete();
		
		return "redirect:/registered";
	}
	
    @GetMapping("/registered")
    public void registered() {
    	
    }
	
   
}
