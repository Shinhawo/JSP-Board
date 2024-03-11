package org.zerock.service;

import org.zerock.domain.AuthVo;
import org.zerock.domain.MemberVo;

public interface UserService {
	
	public MemberVo getUserByEmail(String userEmail);
	
	public MemberVo getUserById(String userid);
	
	public void insertUser(MemberVo member);
	
	public void insertRole(AuthVo auth);
}
