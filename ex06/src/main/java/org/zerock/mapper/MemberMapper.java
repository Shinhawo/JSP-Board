package org.zerock.mapper;

import org.zerock.domain.AuthVo;
import org.zerock.domain.MemberVo;

public interface MemberMapper {

	public MemberVo read(String userId);

	public MemberVo getUserById(String userid);

	public MemberVo getUserByEmail(String userEmail);
	
	public void insert(MemberVo member);

	public void insertRole(AuthVo auth);
}
