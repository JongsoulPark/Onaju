package com.myspring.Onaju.admin.adminCommon.scheduler.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.myspring.Onaju.admin.adminCommon.scheduler.service.ScheduleService;
import com.myspring.Onaju.admin.adminGoods.vo.AdminHostRoomVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostInfoVO;
import com.myspring.Onaju.admin.adminHost.vo.AdminHostVO;
import com.myspring.Onaju.member.vo.MemberVO;

/*
 * 5조 오나주 웹 개발 프로젝트(그린컴퓨터아트학원)
 * 작성자 : 박종설
 * 최종 작성일 : 2022-06-23
 * 관리자 스프링 배치 프로그램 (삭제 관련)
 */

@Controller("schedule")
public class AdminScheduler {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MemberVO schMemVO;
	@Autowired
	private AdminHostVO schHostVO;
	@Autowired
	private AdminHostInfoVO schHostInfoVO;
	@Autowired
	private AdminHostRoomVO schRoomVO;
	@Autowired
	private ScheduleService scheduleService;
	
	// 스프링 배치 프로그램 작성 시 어노테이션 사용하면 안됨
	
	// 작동하고 있는지 확인용
	public void memberSchedule(){
		logger.info("memberSchedule 동작하고 있음 : {}",Calendar.getInstance().getTime());
	}
	
	// 탈퇴 회원 조회 및 삭제 (삭제 트리거에 의해서 삭제 테이블에 들어감)
	// DB u_member 의 del_yn 값이 Y(탈퇴)면 삭제 함
	public void listMemberScheduler() throws Exception {
		String batchResult = "성공";
		
			try {
			List<MemberVO> membersList = scheduleService.listMemberScheduler();
			System.out.println(membersList.size());
			if(membersList != null) {
				for(int i = 0; i < membersList.size(); i++) {
					schMemVO = membersList.get(i);
					String u_id = schMemVO.getU_id();
					scheduleService.deleteMemberScheduler(u_id);
				}
			}
			
		}catch(Exception e) {
			batchResult = "실패";
		}
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("스케줄 실행:["+batchResult+"]"+dateFormat.format(calendar.getTime()));
	}
	
	
	// 탈퇴 판매자 조회 및 삭제(삭제 트리거에 의해서 삭제 테이블에 들어감, 단 cascade 된 하위 테이블은 삭제 트리거 작동을 안함 생각해 볼 것)
	// DB h_host 의 del_yn 값이 Y(탈퇴)면 삭제 함 (cascade된 h_host_info, h_room 같이 삭제)
	public void listHostScheduler() throws Exception{
		String batchResult = "호스트 접근 성공";
		
		try {
			List<AdminHostVO> hostList = scheduleService.listHostScheduler();
			if(hostList != null) {
				for(int i = 0; i < hostList.size(); i++) {
					schHostVO = hostList.get(i);
					String h_id = schHostVO.getH_id();
					scheduleService.deleteHostScheduler(h_id);
				}
			}
		}catch(Exception e) {
			batchResult = "호스트 접근 실패";
		}
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("호스트 스케줄 실행:["+batchResult+"]" + dateFormat.format(calendar.getTime()));
	}
	
	
	// 등록 해지 사업장 조회 및 삭제(삭제 트리거에 의해서 삭제 테이블에 들어감, 단 cascade 된 하위 테이블은 삭제 트리거 작동을 안함 생각해 볼 것)
	// DB h_host_info 의 del_yn 값이 Y(등록 해지)면 삭제 함 (cascade된 h_room 같이 삭제)
	public void listHostInfoScheduler() throws Exception{
		String batchResult = "호스트 info 접근 성공";
		try {
			List<AdminHostInfoVO> hostInfoList = scheduleService.listHostInfoScheduler();
			if(hostInfoList != null) {
				for(int i = 0; i < hostInfoList.size(); i++) {
					schHostInfoVO = hostInfoList.get(i);
					String h_code = schHostInfoVO.getH_code();
					scheduleService.deleteHostInfoScheduler(h_code);
				}
			}
		}catch(Exception e) {
			batchResult = "호스트 info 접근 실패";
		}
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("호스트 info 스케줄 실행:["+batchResult+"]" + dateFormat.format(calendar.getTime()));
	}
	
	
	// 등록 해지 상품 조회 및 삭제( 삭제 트리거에 의해서 삭제 테이블에 들어감)
	// DB h_room 의 del_yn 값이 Y(등록 해지)면 삭제 함
	public void listRoomScheduler() throws Exception{
		String batchResult = "상품 접근 성공";
		try {
			List<AdminHostRoomVO> roomList = scheduleService.listRoomScheduler();
			if(roomList != null) {
				for(int i = 0; i < roomList.size(); i++) {
					schRoomVO = roomList.get(i);
					String room_code = schRoomVO.getRoom_code();
					scheduleService.deleleteRoomScheduler(room_code);
				}
			}
		}catch(Exception e) {
			batchResult = "상품 접근 실패";
		}
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("상품 스케줄 실행:["+batchResult+"]" + dateFormat.format(calendar.getTime()));
	}
	
}
