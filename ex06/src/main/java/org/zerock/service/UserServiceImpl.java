package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.domain.AuthVo;
import org.zerock.domain.MemberVo;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class UserServiceImpl implements UserService{

	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	
	@Override
	public MemberVo getUserByEmail(String userEmail) {
		
		return mapper.getUserByEmail(userEmail);
	}
	
	@Override
	public MemberVo getUserById(String userid) {
		return mapper.getUserById(userid);
	}
	
	@Override
	public void insertRole(AuthVo auth) {

		mapper.insertRole(auth);
	}
	
	@Override
	public void insertUser(MemberVo member) {

		String  encryptedPassword = passwordEncoder.encode(member.getUserpw());
		member.setUserpw(encryptedPassword);
		
		mapper.insert(member);
	}
}
