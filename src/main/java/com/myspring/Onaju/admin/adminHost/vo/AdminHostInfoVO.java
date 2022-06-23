package com.myspring.Onaju.admin.adminHost.vo;

import org.springframework.stereotype.Component;

@Component("adminHostInfoVO")
public class AdminHostInfoVO {
	private String h_code;					// 가맹점 관리번호
	private String h_id;					// 판매자 아이디
	private String h_name;					// 판매자 성함
	private String h_birth_y;				// 판매자 생년월일(년)
	private String h_birth_m;				// 판매자 생년월일(월)
	private String h_birth_d;				// 판매자 생년월일(일)
	private String hostInfo_name;			// 가맹점명	
	private String h_sellerNum;				// 가맹점 사업자번호
	private String h_accountNum;			// 가맹점 계좌번호
	private String zipcode;					// 가맹점 우편번호
	private String roadAddress;				// 가맹점 도로명주소
	private String numberAddress;			// 가맹점 지번
	private String restAddress;				// 가맹점 나머지 주소
	private String host_type;				// 판매자 사업 유형(호텔, 모텔, 숙박)
	private String room_count;				// 가맹점 상품 개수
	private String creDate;					// 가맹점 등록 날짜
	private String del_yn;					// 가맹점 해지 유무
	private String h_gender;				// 판매자 성별
	
	private String h_email1;				// 판매자 이메일
	private String h_email2;				// 판매자 이메일2
	private String h_phone;					// 판매자 전화번호
	private String deputy_name;				// 판매자 대리인 이름
	private String deputy_phone;			// 판매자 대리인 전화번호
	private String deputy_department;		// 판매자 대리인 관계
	private String deputy_birth;			// 판매자 대리인 생년월일

	
	
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	public String getH_code() {
		return h_code;
	}

	public void setH_code(String h_code) {
		this.h_code = h_code;
	}

	public String getH_id() {
		return h_id;
	}

	public void setH_id(String h_id) {
		this.h_id = h_id;
	}

	public String getHostInfo_name() {
		return hostInfo_name;
	}

	public void setHostInfo_name(String hostInfo_name) {
		this.hostInfo_name = hostInfo_name;
	}

	public String getH_sellerNum() {
		return h_sellerNum;
	}

	public void setH_sellerNum(String h_sellerNum) {
		this.h_sellerNum = h_sellerNum;
	}

	public String getH_accountNum() {
		return h_accountNum;
	}

	public void setH_accountNum(String h_accountNum) {
		this.h_accountNum = h_accountNum;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getNumberAddress() {
		return numberAddress;
	}

	public void setNumberAddress(String numberAddress) {
		this.numberAddress = numberAddress;
	}

	public String getRestAddress() {
		return restAddress;
	}

	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}

	public String getHost_type() {
		return host_type;
	}

	public void setHost_type(String host_type) {
		this.host_type = host_type;
	}

	public String getRoom_count() {
		return room_count;
	}

	public void setRoom_count(String room_count) {
		this.room_count = room_count;
	}

	public String getCreDate() {
		return creDate;
	}

	public void setCreDate(String creDate) {
		this.creDate = creDate;
	}
	public String getH_email1() {
		return h_email1;
	}
	public void setH_email1(String h_email1) {
		this.h_email1 = h_email1;
	}
	public String getH_email2() {
		return h_email2;
	}
	public void setH_email2(String h_email2) {
		this.h_email2 = h_email2;
	}
	public String getH_phone() {
		return h_phone;
	}
	public void setH_phone(String h_phone) {
		this.h_phone = h_phone;
	}
	public String getDeputy_name() {
		return deputy_name;
	}
	public void setDeputy_name(String deputy_name) {
		this.deputy_name = deputy_name;
	}
	public String getDeputy_phone() {
		return deputy_phone;
	}
	public void setDeputy_phone(String deputy_phone) {
		this.deputy_phone = deputy_phone;
	}
	public String getDeputy_department() {
		return deputy_department;
	}
	public void setDeputy_department(String deputy_department) {
		this.deputy_department = deputy_department;
	}
	public String getDeputy_birth() {
		return deputy_birth;
	}
	public void setDeputy_birth(String deputy_birth) {
		this.deputy_birth = deputy_birth;
	}
	public String getH_birth_y() {
		return h_birth_y;
	}
	public void setH_birth_y(String h_birth_y) {
		this.h_birth_y = h_birth_y;
	}
	public String getH_birth_m() {
		return h_birth_m;
	}
	public void setH_birth_m(String h_birth_m) {
		this.h_birth_m = h_birth_m;
	}
	public String getH_birth_d() {
		return h_birth_d;
	}
	public void setH_birth_d(String h_birth_d) {
		this.h_birth_d = h_birth_d;
	}
	public String getH_gender() {
		return h_gender;
	}
	public void setH_gender(String h_gender) {
		this.h_gender = h_gender;
	}
	
	
}
