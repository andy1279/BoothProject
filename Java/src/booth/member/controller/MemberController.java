package booth.member.controller;

import booth.member.model.MemberDAO;
import booth.member.model.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/member")
//@MultipartConfig(location="/testfile", fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)

public class MemberController {
	@RequestMapping("/logout")
	public void logout(HttpSession session, HttpServletResponse response) throws IOException
	{
		session.removeAttribute("loginStatus");
		session.removeAttribute("MemberDTO");
		response.sendRedirect("../");
	}

	@RequestMapping("/idcheck")
	public void idcheck(@RequestParam("userId") String userId, HttpServletResponse response) throws IOException {
		MemberDAO dao = new MemberDAO();
		if (dao.isIdDuplicated(userId))
		{
			response.getWriter().write("DUPLICATED");
		}
		else
		{
			response.getWriter().write("USABLE");
		}
	}
	
	@RequestMapping("/login")
	public void login(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, HttpServletResponse response, HttpSession session) throws IOException {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.login(userId, userPw);
		if (dto != null)
		{
			session.setAttribute("loginStatus", "true");
			session.setAttribute("MemberDTO", dto);
			response.getWriter().write("SUCCESS");
		}
		else
		{
			response.getWriter().write("FAIL");
		}
	}
	
	@RequestMapping("/join")
	public void Register(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw,
			@RequestParam("userNick") String userNick, @RequestParam("userPhoneNum") String userPhoneNum,
			@RequestParam("userEmail") String userEmail, HttpServletResponse response, HttpSession session) throws IOException {
		MemberDTO dto = new MemberDTO();
		dto.setUserId(userId);
		dto.setUserPw(userPw);
		dto.setUserNick(userNick);
		dto.setUserPhoneNum(userPhoneNum);
		dto.setUserEmail(userEmail);
		MemberDAO dao = new MemberDAO();
		if (dao.insert(dto))
		{
			response.getWriter().write("SUCCESS");
		}
		else
		{
			response.getWriter().write("FAIL");
		}
	}

}
