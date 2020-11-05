package booth.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import booth.member.action.memberAction;
import booth.member.action.memberJoinAction;
import booth.member.action.memberLoginAction;

@WebServlet("/member/*")

public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doHandle(HttpServletRequest request, HttpServletResponse response, boolean bIsGet) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String viewPage = null;
		memberAction command = null;
		String uri = request.getRequestURI();

		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		
		if (com != null && com.trim().contentEquals("memberJoin")) {
			command = new memberJoinAction();
			command.execute(request, response);
			return;
		}else if (com != null && com.trim().contentEquals("memberLogin")) {
			command = new memberLoginAction();
			command.execute(request, response);
			return;
			//viewPage = "mView.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response, true);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response, false);
	}

}
