package com.member.hp;

import java.util.Date;

public class MemberDTO {
	private String member_id, member_pw, member_name;
	private int member_age;
	private String member_address, member_tel;

	
	public MemberDTO() {}
	
	public MemberDTO(String member_id, String member_pw, String member_name, int member_age, String member_address,
			String member_tel) {
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_age = member_age;
		this.member_address = member_address;
		this.member_tel = member_tel;
	}
	

	//getter setter

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public int getMember_age() {
		return member_age;
	}

	public void setMember_age(int member_age) {
		this.member_age = member_age;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public String getMember_tel() {
		return member_tel;
	}

	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}


	
}
