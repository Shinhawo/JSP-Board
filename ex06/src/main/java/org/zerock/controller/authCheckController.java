package org.zerock.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.MailSendService;
import org.zerock.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/auth/")
@RestController
@Log4j
@AllArgsConstructor
public class authCheckController {

	private UserService service;
	private MailSendService mailService;
	
    @GetMapping(value = "/checkId",
    			produces = {
					MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Boolean> checkId(@RequestParam("userid") String userid) {
        return ResponseEntity.ok(service.getUserById(userid) != null);
    }
	
	@GetMapping(value = "/checkEmail",
				produces = {
				MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Boolean> checkEmail(@RequestParam("userEmail") String userEmail){
		
		return ResponseEntity.ok(service.getUserByEmail(userEmail) != null);
	}
	
	//이메일 인증
	@GetMapping("/mailCheck")
	@ResponseBody
	public String mailCheck(String email) {
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("이메일 인증 이메일 : " + email);
		
		return mailService.joinEmail(email);
	}

}
