package com.rail.dto;

public class MemberVO {
	
	private String id;
	private String password;
	private String name;
	private String email;
	private String birth;
	private String phone;
	private String adminnum;
	private Integer hint;
	private String answer;
	private Integer kakao;
	public Integer getKakao() {
		return kakao;
	}
	public void setKakao(Integer kakao) {
		this.kakao = kakao;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdminnum() {
		return adminnum;
	}
	public void setAdminnum(String adminnum) {
		this.adminnum = adminnum;
	}
	public Integer getHint() {
		return hint;
	}
	public void setHint(Integer hint) {
		this.hint = hint;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
