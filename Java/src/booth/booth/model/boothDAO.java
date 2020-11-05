package booth.booth.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class boothDAO {
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public boothDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/BOOTH");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if(con != null) {
				con.close();
				con = null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean createBooth() {
		String sql = "insert into BOOTH_MEMBER(USER_ID, USER_PW, USER_NICK, USER_PHONENUM, USER_EMAIL) values(?,?,?,?,?)";
		boolean check = false;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPw());
			pstmt.setString(3, dto.getUserNick());
			pstmt.setString(4, dto.getUserPhoneNum());
			pstmt.setString(5, dto.getUserEmail());
			int x = pstmt.executeUpdate();
			
			if (x < 1) {
				System.out.println("정상적으로 저장되지 않았습니다.");
			} else {
				check = true;
			}
			pstmt.close();
		}catch(SQLException ex) {
			System.out.println("SQL insert 오류 : " + ex.getLocalizedMessage());
			check = false;
		}
		return check;
	}
	public MemberDTO view(String id) {
		String sql = "select pwd, name, email, joinDate from member where id=?";
		MemberDTO dto = new MemberDTO();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto.setUserId(id);
				dto.setUserPw(rs.getString("USER_PW"));
				dto.setUserNick(rs.getString("USER_NICK"));
				dto.setUserEmail(rs.getString("USER_EMAIL"));
				dto.setUserPhoneNum(rs.getString("USER_PHONENUM"));
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
}