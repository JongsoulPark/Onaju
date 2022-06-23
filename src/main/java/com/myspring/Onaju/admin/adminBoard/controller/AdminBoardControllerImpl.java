package com.myspring.Onaju.admin.adminBoard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.Onaju.admin.admin.vo.AdminVO;
import com.myspring.Onaju.admin.adminBoard.service.AdminBoardService;
import com.myspring.Onaju.admin.adminBoard.vo.AdminEnquireReplyVO;
import com.myspring.Onaju.admin.adminBoard.vo.AdminNoticeVO;
import com.myspring.Onaju.admin.adminCommon.paging.Criteria;
import com.myspring.Onaju.admin.adminCommon.paging.PageVO;

/*
 * 5조 오나주 웹 개발 프로젝트(그린컴퓨터아트학원)
 * 작성자 : 박종설
 * 최종 작성일 : 2022-06-23
 * 관리자 게시판 관리(공지사항, 1대1 문의)
 */

@RestController("adminBoardController")
public class AdminBoardControllerImpl implements AdminBoardController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AdminBoardService adminBoardService;
	@Autowired
	private AdminVO adminVO;
	
	
	// 이미지 파일 경로 serlet-context에 설정
	@Resource(name="adminUploadPath")
	String adminUploadPath;
	
	
	//  ============================== 공지사항 게시판  ============================== 
	
	// 공지사항 목록
	@Override
	@RequestMapping(value = "/admin/noticeList.do", method = RequestMethod.GET)
	public ModelAndView adminNoticeList(Criteria cri) throws Exception {		
		
		// datepicker 끝 날짜 선택 시 0시를 지정하기 때문에 해당 날짜에 조건을 검색할 수 없음 따라서 날짜 1을 더해줌 
		if(cri.getJoin_endDate() != "" && cri.getJoin_endDate() != null) {
			String endDate = cri.getJoin_endDate();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(endDate);
			Date plus_date = new Date(date.getTime() + (1000*60*60*24));
			String join_endDate = DateFormatUtils.format(plus_date, "yyyy-MM-dd");
		
			cri.setJoin_endDate(join_endDate);
		}
		
		ModelAndView mav = new ModelAndView();
		
		int total = adminBoardService.noticeListTotal(cri);
		
		List<Map<String, Object>> noticeList = adminBoardService.noticeList(cri);
		
		mav.addObject("noticeList", noticeList);
		mav.addObject("pageMaker", new PageVO(cri,total));
		
		return mav; 
	}
	
	
	// 공지사항 상세화면
	@Override
	@RequestMapping(value = "/admin/noticeDetail.do", method = RequestMethod.GET)
	public ModelAndView adminNoticeDetail(@RequestParam("notice_code")String notice_code, @ModelAttribute("cri") Criteria cri) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> noticeMap = adminBoardService.noticeDetail(notice_code);
		
		mav.addObject("noticeMap", noticeMap);
		
		return mav;
	}
	
	
	// 공지사항 이미지 호출
	@Override
	@RequestMapping(value = "/admin/imgFile.do", method= RequestMethod.GET)
	public void imgFile(String creID, String notice_code, HttpServletResponse response) throws Exception {
			
		OutputStream out = response.getOutputStream();
		Map<String, Object> imgInfoMap = new HashMap<String, Object>();
		imgInfoMap.put("a_id", creID);
		imgInfoMap.put("notice_code", notice_code);
		String save_File_Name = adminBoardService.getImgFile(imgInfoMap);
		String filePath = adminUploadPath +"\\"+ save_File_Name;
			
		File img = new File(filePath);
		FileInputStream in = new FileInputStream(img);
		
		byte[] buffer = new byte[1024*8];
		while (true) {
			int count = in.read(buffer);
			if(count == -1) 
				break;
			out.write(buffer,0,count);
		}
		in.close();
		out.close();	
	}
	
	
	// 공지사항 등록 화면 폼
	@Override
	@RequestMapping(value = "/admin/noticeForm.do", method = RequestMethod.GET)
	public ModelAndView adminNoticeForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav =new ModelAndView(); 
		String viewName = (String)request.getAttribute("viewName"); 
		mav.setViewName(viewName); 
		return mav; 
	}

	//공지사항 게시글 등록(게시글 내용 + 이미지)
	@Override
	@RequestMapping(value = "/admin/insertNotice.do", method = RequestMethod.POST)
	public ModelAndView insertNotice(AdminNoticeVO noticeVO, MultipartFile file, HttpServletRequest request) throws Exception {
		
		ModelAndView mav = new ModelAndView("redirect:/admin/noticeList.do");
		// 공지사항은 관리자가 등록하기 때문에 관리자 정보(로그인 시 저장한 정보)를 불러오기 위해 세션 사용
		HttpSession session = request.getSession();
		adminVO = (AdminVO)session.getAttribute("adminInfo");
		String a_id = adminVO.getA_id();
		
		
		// 테스트 끝날 시 삭제 로거보단 디버깅이 편한거 같음
		logger.debug("==========vo테스트==========");
		logger.debug("제목 : " + noticeVO.getNotice_title());
		logger.debug("내용 : " + noticeVO.getNotice_content());
		logger.debug("작성자 : " + a_id);
		
		noticeVO.setA_id(a_id);
		// 입력값이 담긴 noticeVO에 DB insert 시 필수 값인 a_id 값을 담고 서비스로 보냄
		adminBoardService.insertNotice(noticeVO);
		
		// DB에 저장이 완료되면 생성되는 auto_increment 번호를 notice_code 변수에 저장
		int notice_code = noticeVO.getNotice_code();
		// DB에 제대로 저장이 되었다면 숫자 1
		if(notice_code != 0) {
			
			logger.debug("==========게시번호 확인==========");
			logger.debug("게시번호 : "+ notice_code);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("a_id", a_id);
			map.put("notice_code", notice_code);
			
			// file에 이미지 정보가 담겨 있는지 확인
			if(!file.isEmpty()) {
				// 담겨 있다면 같은 클래스 내에 있는 parseFileInfo 호출
				Map<String, Object> imgFile = parseFileInfo(map, file);
				adminBoardService.insertImgFile(imgFile);
			}
		}
		logger.debug("==========시작==========");
		logger.debug("파일이름 : "+ file.getName());
		logger.debug("파일 실제이름 : " + file.getOriginalFilename());
		logger.debug("파일 크기 : " + file.getSize());
		logger.debug("파일 타입 : " + file.getContentType());
		logger.debug("==========끄읕==========");
		
		return mav;
	}

	//공지사항 이미지 폴더 저장
	public Map<String, Object> parseFileInfo(Map<String, Object> map, MultipartFile file) throws Exception {
		
		String noticeCode = String.valueOf(map.get("notice_code"));
		String creID = (String)map.get("a_id");
		
		Map<String, Object> imgFile = new HashMap<String, Object>();
		
		File target = new File(adminUploadPath);
		if(!target.exists()) target.mkdirs();
		
		String orgFileName = file.getOriginalFilename();
		String orgFileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));
		String saveFileName = UUID.randomUUID().toString().replace("-", "") + orgFileExtension;
		Long saveFileSize = file.getSize();
		
		logger.debug("==========파일전송 시작 ==========");
		logger.debug("파일 실제 이름 : " + orgFileName);
		logger.debug("파일 저장 이름 : " + saveFileName);
		logger.debug("파일 크기 : " + saveFileSize);
		logger.debug("파일 타입 : " + file.getContentType());
		logger.debug("==========파일전송 종료 ==========");
		
		target = new File(adminUploadPath, saveFileName);
		file.transferTo(target);
		
		imgFile.put("notice_code", noticeCode);
		imgFile.put("Org_File_Name", orgFileName);
		imgFile.put("Save_File_Name", saveFileName);
		imgFile.put("File_Size", saveFileSize);
		imgFile.put("creID", creID);
		
		return imgFile;
	}
	
	
	// 공지사항 수정 화면 폼
	@Override
	@RequestMapping(value = "/admin/noticeModify.do", method = RequestMethod.GET)
	public ModelAndView noticeModify(String notice_code, @ModelAttribute("cri") Criteria cri) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		Map<String, Object> noticeMap = adminBoardService.noticeDetail(notice_code);
		mav.addObject("noticeMap", noticeMap);
		return mav;
	}
	
	
	// 공지사항 수정 화면 내 이미지 삭제
	@Override
	@RequestMapping(value = "/admin/imgDelete.do", method = RequestMethod.POST)
	public ResponseEntity<String> imgDelete(@RequestParam Map<String, Object> delet_img) {
		
		String Save_File_Name = (String)delet_img.get("Save_File_Name");
		String img_code = (String)delet_img.get("img_code");
		File filePath = new File(adminUploadPath +"\\"+ Save_File_Name);
		
		if(filePath.exists()) {
			filePath.delete();
			adminBoardService.deleteNoticeImg(img_code);
			return new ResponseEntity<String>("success", HttpStatus.OK);
			
		}else{
			adminBoardService.deleteNoticeImg(img_code);
			return new ResponseEntity<String>("failed",HttpStatus.OK);
		}
	}
	
	
	// 공지사항 수정
	//임시방편 하드코딩! 이미지 insert부분은 parseFileInfo 메서드와 통합하여 코드 줄일 것 (결합도? 낮출것)
	@Override
	@RequestMapping(value = "/admin/updateNotice.do", method = RequestMethod.POST)
	public ModelAndView updateNotice(@RequestParam Map<String, Object> map, MultipartFile file, @ModelAttribute Criteria cri) throws Exception {
		
		ModelAndView mav = new ModelAndView("redirect:/admin/noticeList.do");
		
		String Save_File_Name = (String)map.get("Save_File_Name");
		
		Map<String, Object> imgFile = new HashMap<String, Object>();
		String noticeCode = (String)map.get("notice_code");
		String img_code = (String)map.get("img_code");
		String creID = (String)map.get("a_id");
		
		if(!Save_File_Name.isEmpty()) { //기존 이미지 파일 존재 유무
			if(file.getOriginalFilename() != "") { // 새로운 이미지 파일 존재 유무
				File filePath = new File(adminUploadPath +"\\"+Save_File_Name);
				if(filePath.exists()) filePath.delete();
					
				String orgFileName = file.getOriginalFilename();
				String orgFileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));
				String saveFileName = UUID.randomUUID().toString().replace("-", "") + orgFileExtension;
				Long saveFileSize = file.getSize();
				
				File target = new File(adminUploadPath);	
				target = new File(adminUploadPath, saveFileName);
				file.transferTo(target);
				
				imgFile.put("notice_code", noticeCode);
				imgFile.put("Org_File_Name", orgFileName);
				imgFile.put("File_Size", saveFileSize);
				imgFile.put("img_code", img_code);
				imgFile.put("Save_File_Name", saveFileName);
					
				adminBoardService.updateImgFile(imgFile);
				adminBoardService.updateNotice(map);	
			}else { // 새로운 이미지 파일이 존재 하지 않을 시
				adminBoardService.updateNotice(map);
			}
		
		}else { // 기존 이미자 파일이 존재 하지 않을 시
			String orgFileName = file.getOriginalFilename();
			String orgFileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));
			String saveFileName = UUID.randomUUID().toString().replace("-", "") + orgFileExtension;
			Long saveFileSize = file.getSize();
			
			File target = new File(adminUploadPath);	
			target = new File(adminUploadPath, saveFileName);
			file.transferTo(target);
			
			imgFile.put("creID", creID);
			imgFile.put("Save_File_Name", saveFileName);
			imgFile.put("notice_code", noticeCode);
			imgFile.put("Org_File_Name", orgFileName);
			imgFile.put("File_Size", saveFileSize);
			
			adminBoardService.insertImgFile(imgFile);
			adminBoardService.updateNotice(map);	
		}	
		return mav;
	}
	
	
	// 공지사항 삭제
	@Override
	@RequestMapping(value = "/admin/deleteNotice.do", method = RequestMethod.POST)
	public ModelAndView deleteNotice(@RequestParam String notice_code, @ModelAttribute("cri") Criteria cri) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		int update_post_check = adminBoardService.deleteNotice(notice_code);
		if(update_post_check == 1) {
			String message = "게시물이 중지 되었습니다.";
			Map<String, Object> noticeMap = adminBoardService.noticeDetail(notice_code);
			mav.addObject("noticeMap", noticeMap);
			mav.addObject("message", message);
		}else {
			String message = "게시물 중지 작업이 실패 하였습니다.";
			Map<String, Object> noticeMap = adminBoardService.noticeDetail(notice_code);
			mav.addObject("noticeMap", noticeMap);
			mav.addObject("message", message);
		}
		mav.setViewName("/admin/noticeDetail");
		
		return mav;
	}
		
		
	
	//  ============================== 1대1 게시판  ============================== 
		
	
	// 1대1 게시판 목록
	@Override
	@RequestMapping(value = "/admin/enquireBoard.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView enquireBoardList(Criteria cri) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		int total = adminBoardService.enquireListTotal(cri);
		
		List<Map<String, Object>> enquireList = adminBoardService.enquireBoardList(cri);
		mav.addObject("enquireList", enquireList);
		mav.addObject("pageMaker", new PageVO(cri, total));
		return mav;
	}
	
	
	// 1대1 게시판 상세
	@Override
	@RequestMapping(value = "/admin/enquireDetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView enquireBoardDetail(@RequestParam("enquire_NO") String enquire_NO, @ModelAttribute("cri") Criteria cri) throws Exception {
		
		adminBoardService.updateHit(enquire_NO);
		
		ModelAndView mav = new ModelAndView();
		List<Map<String, Object>> enquireDetail = adminBoardService.enquireBoardDetail(enquire_NO);
		
		mav.addObject("enquireDetail", enquireDetail);
		return mav;
	}
	
	
	// 1대1 게시판 댓글 등록
	@Override
	@RequestMapping(value = "admin/newReply.do", method = RequestMethod.POST)
	public ResponseEntity<String> insertEnquireReply(@ModelAttribute("replyVO") AdminEnquireReplyVO replyVO, HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		adminVO = (AdminVO)session.getAttribute("adminInfo");
		replyVO.setA_id(adminVO.getA_id());
		int insertReply = adminBoardService.insertEnquireReply(replyVO);
		return insertReply == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	// 1대1 게시판 댓글 목록 호출
	@Override
	@RequestMapping(value = "/admin/enquireReplyList.do", method = {RequestMethod.GET, RequestMethod.POST} )
	public ResponseEntity<List<Map<String, Object>>> ajaxcommentList(AdminEnquireReplyVO replyVO){
		
		List<Map<String, Object>> replysList = adminBoardService.enquireReplyDetail(replyVO);
		return new ResponseEntity<>(replysList, HttpStatus.OK);
	}
	
	
	// 1대1 게시판 댓글 삭제
	@Override
	@RequestMapping(value = "/admin/replyDelete.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Map<String, Object>> replydelete(@RequestParam Map<String, Object> reMap) {
		
		Map<String,Object> data = new HashMap<String, Object>();
		String re_NO = (String)reMap.get("re_NO");
		String enquire_NO = (String)reMap.get("enquire_NO");
		int delete_re_NO = adminBoardService.deleteReply(re_NO);
		
		if(delete_re_NO == 1) {
			String message = "success";	
			data.put("message", message);
			data.put("enquire_NO", enquire_NO);
		}else {
			String message = "failed";
			data.put("message", message);
			data.put("enquire_NO", enquire_NO);
		}
	
		return new ResponseEntity<Map<String, Object>>(data, HttpStatus.OK);
	}
	
	
}
