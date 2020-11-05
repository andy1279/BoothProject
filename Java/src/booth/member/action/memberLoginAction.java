package booth.member.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import booth.member.model.MemberDAO;
import booth.member.model.MemberDTO;

public class memberLoginAction implements memberAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO userData = memberDAO.login(request.getParameter("user_id"), request.getParameter("user_pw"));
		if (userData == null)
		{// Login Failed
			JSONObject json = new JSONObject();
			json.put("STATUS", "FAIL");
			response.getWriter().write(json.toString());
		}
		else
		{
			JSONObject json = new JSONObject();
			json.put("STATUS", "SUCCESS");
			json.put("USER_ID", userData.getUserId());
			json.put("USER_NICK", userData.getUserNick());
			response.getWriter().write(json.toString());
		}
	}

}
