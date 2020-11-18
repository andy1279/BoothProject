package booth.booth.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
	private boothDTO getBoothByBoothId(int boothId) {
		String sql = "SELECT * FROM BOOTH_ITEM where BOOTH_ID = ?";
		boothDTO result = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boothId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new boothDTO();
				result.setBoothId(rs.getInt("BOOTH_ID"));
				result.setBoothName(rs.getString("BOOTH_NAME"));
				result.setBoothInfo(rs.getString("BOOTH_INFO"));
				result.setBoothImage(rs.getBlob("BOOTH_IMAGE"));
				result.setBoothBoss(rs.getString("BOOTH_BOSS"));
				result.setBoothInviteCode(rs.getString("BOOTH_INVITE_CODE"));
				result.setBoothNeedsConfirm(rs.getInt("BOOTH_NEEDS_CONFIRM"));
				result.setBoothBirth(rs.getDate("BOOTH_BIRTH"));
			}
			pstmt.close();
		} catch (SQLException ex) {
		} finally {
			close();
		}
		return result;
	}
	private ArrayList<Integer> _getBoothList(String userId) {
		ArrayList<Integer> boothList = null;
		String sql = "SELECT BOOTH_ID FROM BOOTH_ITEM_MEMBER_CONNECTION WHERE USER_ID = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				boothList = new ArrayList<Integer>();
				do {
					boothList.add(rs.getInt("BOOTH_ID"));
				}while(rs.next());
			}
			pstmt.close();
		} catch (SQLException ex) {
		} finally {
			close();
		}
		return boothList;
	}
	public ArrayList<boothDTO> getBoothList(String userId) {
		ArrayList<boothDTO> boothList = null;
		ArrayList<Integer> boothIdList = _getBoothList(userId);
		if (boothIdList != null)
		{
			boothList = new ArrayList<boothDTO>();
			for (int i = 0; i < boothIdList.size(); i++)
			{
				boothDTO dto = getBoothByBoothId(boothIdList.get(i));
				if (dto == null) {
					System.out.format("[getBoothList] getBoothByBoothId : %d failed\n", boothIdList.get(i));
				} else {
					boothList.add(dto);
				}
			}
		}
		return boothList;
	}
	public boolean createBooth(boothDTO dto) {
		String sql = "insert into BOOTH_ITEM(BOOTH_NAME, BOOTH_INFO, BOOTH_IMAGE, BOOTH_BOSS,"
				+ " BOOTH_INVITE_CODE,BOOTH_NEEDS_CONFIRM) values(?,?,?,?,?)";
		boolean check = false;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoothName());
			pstmt.setString(2, dto.getBoothInfo());
			pstmt.setBlob(3, dto.getBoothImage());
			pstmt.setString(4, dto.getBoothBoss());
			pstmt.setString(5, dto.getBoothInviteCode());
			pstmt.setInt(5, dto.getBoothNeedsConfirm());
			int x = pstmt.executeUpdate();
			
			if (x < 1) {
				System.out.println("정상적으로 저장되지 않았습니다.");
			} else {
				check = true;
			}
			rs.close();
			pstmt.close();
		}catch(SQLException ex) {
			System.out.println("SQL insert 오류 : " + ex.getLocalizedMessage());
			check = false;
		}
		return check;
	}
	public boolean deleteBoothById(int boothId) {
		boolean check = false;
		String sql = "delete BOOTH_ITEM where BOOTH_ID = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boothId);
			if (pstmt.executeUpdate() < 1) {
				check = false;
			} else {
				check = true;
			}
			rs.close();
			pstmt.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return check;
	}
	public boolean updateBoothById(boothDTO dto) {
		boolean check = false;
		String sql = "update BOOTH_ITEM set BOOTH_NAME = ?,"
				+ "BOOTH_INFO = ?,"
				+ "BOOTH_IMAGE = ?,"
				+ "BOOTH_BOSS = ?,"
				+ "BOOTH_INVITE_CODE = ?,"
				+ "BOOTH_NEEDS_CONFIRM = ? where BOOTH_ID = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoothName());
			pstmt.setString(2, dto.getBoothInfo());
			pstmt.setBlob(3, dto.getBoothImage());
			pstmt.setString(4, dto.getBoothBoss());
			pstmt.setString(5, dto.getBoothInviteCode());
			pstmt.setInt(6, dto.getBoothNeedsConfirm());
			pstmt.setInt(7, dto.getBoothId());
			
			if (pstmt.executeUpdate() < 1) {
				check = false;
			} else {
				check = true;
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return check;
	}
}