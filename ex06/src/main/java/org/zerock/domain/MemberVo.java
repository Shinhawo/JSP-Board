package org.zerock.domain;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVo {

	private String userid;
	private String userpw;
	private String userName;
	private String userEmail;
	private String enabled;
	
	private Date regDate;
	private Date updateDate;
	private List<AuthVo> authList;
	
	@Builder
	public MemberVo(String userid, String userpw, String userName, String userEmail, String enabled, Date regDate,
			Date updateDate) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.userName = userName;
		this.userEmail = userEmail;
		this.enabled = enabled;
		this.regDate = regDate;
		this.updateDate = updateDate;
	}
	
	
}
