package com.myspring.Onaju.admin.adminOrder.vo;

import org.springframework.stereotype.Component;

@Component("adminOrderVO")
public class AdminOrderVO {
	
	//주문 정보
	private String order_code;			// 주문 번호
	private String u_id;				// 주문 회원 아이디
	private String h_code;				// 가맹점 관리 번호
	private String room_code;			// 상품 관리 번호
	private String order_name;			// 예약자 이름
	private String order_phone;			// 예약자 전화번호
	private String order_email1;		// 예약자 이메일
	private String order_email2;		// 예약자 이메일 뒤
	private String checkIn_date;		// 체크인 날짜
	private String checkOut_date;		// 체크아웃 날짜
	private String people_count;		// 예약 인원
	private String room_fee;			// 상품 가격
	private String pay_type;			// 결제 타입
	private String discount;			// 할인율
	private String total;				// 총 결제 금액
	private String pay_state;			// 결제 상태
	private String creDate;				// 예약 날짜
	private String reservation_state;	// 판매자 예약 승인 여부
	private String use_state;			// 예약자 상품 이용 여부
	
	//주문자 정보
	private String u_name;				// 회원 이름
	private String u_point;				// 포인트
	private String u_grade;				// 회원 등급
	
	//사업장 정보
	private String hostInfo_name;		// 가맹점명
	private String zipcode;				// 가맹점 주소
	private String roadAddress;			// 가맹점 도로명 주소
	private String numberAddress;		// 가맹점 지번
	private String restAddress;			// 가맹점 나머지 주소
	private String host_type;			// 가맹점 유형(호텔, 모텔, 민박)
	
	//판매자 정보
	private String h_name;				// 판매자 성함
	private String h_phone;				// 판매자 전화번호
	private String h_email1;			// 판매자 이메일
	private String h_email2;			// 판매자 이메일 뒤
	private String deputy_name;			// 대리인 성함
	private String deputy_phone;		// 대리인 전화번호
	
	//방정보
	private String room_number;			// 상품 호실
	private String room_type;			// 상품 타입 (예 : 스위트룸)
	private String able_checkIn;		// 체크인 가능한 시간
	private String able_checkOut;		// 체크아웃 가능한 시간
	
	
		
	public String getReservation_state() {
		return reservation_state;
	}
	public void setReservation_state(String reservation_state) {
		this.reservation_state = reservation_state;
  }
	public String getUse_state() {
		return use_state;
	}
	public void setUse_state(String use_state) {
		this.use_state = use_state;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getH_code() {
		return h_code;
	}
	public void setH_code(String h_code) {
		this.h_code = h_code;
	}
	public String getRoom_code() {
		return room_code;
	}
	public void setRoom_code(String room_code) {
		this.room_code = room_code;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}
	public String getOrder_email1() {
		return order_email1;
	}
	public void setOrder_email1(String order_email1) {
		this.order_email1 = order_email1;
	}
	public String getOrder_email2() {
		return order_email2;
	}
	public void setOrder_email2(String order_email2) {
		this.order_email2 = order_email2;
	}
	public String getCheckIn_date() {
		return checkIn_date;
	}
	public void setCheckIn_date(String checkIn_date) {
		this.checkIn_date = checkIn_date;
	}
	public String getCheckOut_date() {
		return checkOut_date;
	}
	public void setCheckOut_date(String checkOut_date) {
		this.checkOut_date = checkOut_date;
	}
	public String getPeople_count() {
		return people_count;
	}
	public void setPeople_count(String people_count) {
		this.people_count = people_count;
	}
	public String getRoom_fee() {
		return room_fee;
	}
	public void setRoom_fee(String room_fee) {
		this.room_fee = room_fee;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getPay_state() {
		return pay_state;
	}
	public void setPay_state(String pay_state) {
		this.pay_state = pay_state;
	}
	public String getCreDate() {
		return creDate;
	}
	public void setCreDate(String creDate) {
		this.creDate = creDate;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_point() {
		return u_point;
	}
	public void setU_point(String u_point) {
		this.u_point = u_point;
	}
	public String getU_grade() {
		return u_grade;
	}
	public void setU_grade(String u_grade) {
		this.u_grade = u_grade;
	}
	public String getHostInfo_name() {
		return hostInfo_name;
	}
	public void setHostInfo_name(String hostInfo_name) {
		this.hostInfo_name = hostInfo_name;
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
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getH_phone() {
		return h_phone;
	}
	public void setH_phone(String h_phone) {
		this.h_phone = h_phone;
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
	public String getRoom_number() {
		return room_number;
	}
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getAble_checkIn() {
		return able_checkIn;
	}
	public void setAble_checkIn(String able_checkIn) {
		this.able_checkIn = able_checkIn;
	}
	public String getAble_checkOut() {
		return able_checkOut;
	}
	public void setAble_checkOut(String able_checkOut) {
		this.able_checkOut = able_checkOut;
	}
	
	
}
