package com.budong.model.interfaces;

import java.util.Date;

import com.budong.model.dto.MemberDTO;

public interface MemberDAO {
	public MemberDTO login(MemberDTO dto);
	
	public int isAvailableId(String mem_id); 
	
	public int insertMember(MemberDTO dto); 

}
