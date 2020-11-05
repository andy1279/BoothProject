package booth.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booth.member.model.*;

public class memberJoinAction implements memberAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDTO dto = new MemberDTO();
		dto.setUserId(request.getParameter("user_id"));
		dto.setUserPw(request.getParameter("user_pw"));
		dto.setUserNick(request.getParameter("user_nick"));
		dto.setUserPhoneNum(request.getParameter("user_phonenum"));
		dto.setUserEmail(request.getParameter("user_email"));
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
