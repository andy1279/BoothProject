package booth.article.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleDAO {
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ArticleDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/BOOTH");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean createArticle(ArticleDTO dto) {
		boolean result = false;
		String sql = "INSERT into BOOTH_ARTICLE(ARTICLE_NAME, ARTICLE_CONTENT, ARTICLE_SAMPLE_CONTENT, ARTICLE_MAINPICTURE, ARTICLE_USERID, ARTICLE_NOTICE, ARTICLE_BOOTH_ID)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getArticleName());
			pstmt.setClob(2, dto.getArticleContent());
			pstmt.setString(3, dto.getArticleSampleContent());
			pstmt.setString(4, dto.getArticleMainPictureURL());
			pstmt.setString(5, dto.getArticleUserId());
			pstmt.setInt(6, dto.getArticleNotice());
			pstmt.setInt(7, dto.getArticleBoothId());
			int x = pstmt.executeUpdate();

			if (x < 1) {
				System.out.println("정상적으로 저장되지 않았습니다.");
			} else {
				result = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public ArrayList<ArticleDTO> searchArticle(ArticleDTO.searchMethod method, int boothId, String ref)
	{
		String sql = null;
		ArrayList<ArticleDTO> result = new ArrayList<ArticleDTO>();
		try {
			con = ds.getConnection();
			switch(method)
			{
			case SEARCH_BY_ARTICLE_NAME:
				sql = "SELECT * FROM BOOTH_ARTICLE where ARTICLE_NAME like %?% and ARTICLE_BOOTH_ID = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ref);
				pstmt.setInt(2, boothId);
				break;
			case SEARCH_BY_ARTICLE_CONTENT:
				sql = "SELECT * FROM BOOTH_ARTICLE where ARTICLE_CONTENT like %?% and ARTICLE_BOOTH_ID = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ref);
				pstmt.setInt(2, boothId);
				break;
			case SEARCH_BY_ARTICLE_USERID:
				sql = "SELECT * FROM BOOTH_ARTICLE where ARTICLE_USERID = ? and ARTICLE_BOOTH_ID = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ref);
				pstmt.setInt(2, boothId);
				break;
			default:
				sql = "SELECT * FROM BOOTH_ARTICLE where ARTICLE_BOOTH_ID = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, boothId);
				break;
			}
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				ArticleDTO dto = new ArticleDTO();
				dto.setArticleId(rs.getInt("ARTICLE_ID"));
				dto.setArticleName(rs.getString("ARTICLE_NAME"));
				dto.setArticleContent(rs.getClob("ARTICLE_CONTENT"));
				dto.setArticleSampleContent(rs.getString("ARTICLE_SAMPLE_CONTENT"));
				dto.setArticleMainPictureURL(rs.getString("ARTICLE_MAINPICTURE"));
				dto.setArticleUserId(rs.getString("ARTICLE_USERID"));
				dto.setArticleNotice(rs.getInt("ARTICLE_NOTICE"));
				dto.setArticleBoothId(rs.getInt("ARTICLE_BOOTH_ID"));
				result.add(dto);
			}
			pstmt.close();
		}catch(SQLException e) {
			System.out.println("SQL insert 오류 : " + e.getLocalizedMessage());
		} finally {
			close();
		}
		return result;
	}

	public ArticleDTO getArticleById(int BoothId, int ArticleId) {
		String sql = "SELECT * FROM BOOTH_ARTICLE where ARTICLE_ID = ? and ARTICLE_BOOTH_ID = ?";
		ArticleDTO result = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ArticleId);
			pstmt.setInt(2, BoothId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new ArticleDTO();
				result.setArticleId(rs.getInt("ARTICLE_ID"));
				result.setArticleName(rs.getString("ARTICLE_NAME"));
				result.setArticleContent(rs.getClob("ARTICLE_CONTENT"));
				result.setArticleSampleContent(rs.getString("ARTICLE_SAMPLE_CONTENT"));
				result.setArticleMainPictureURL(rs.getString("ARTICLE_MAINPICTURE"));
				result.setArticleUserId(rs.getString("ARTICLE_USERID"));
				result.setArticleNotice(rs.getInt("ARTICLE_NOTICE"));
				result.setArticleBoothId(rs.getInt("ARTICLE_BOOTH_ID"));
			}
			pstmt.close();
		} catch (SQLException ex) {
		} finally {
			close();
		}
		return result;
	}

	public boolean deleteArticle(int boothId, int articleId) {
		String sql = "DELETE FROM BOOTH_ARTICLE where ARTICLE_ID= ?  and ARTICLE_BOOTH_ID = ?";
		boolean result = false;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleId);
			pstmt.setInt(2, boothId);
			int x = pstmt.executeUpdate();

			if ( x < 1 ) {
				System.out.format("[deleteArticle] boothId : %d, articleId : %d failed\n", boothId, articleId);
			} else {
				result = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	public boolean modifyArticle(ArticleDTO dto) {
		String sql = "UPDATE BOOTH_ARTICLE SET "
				+ "ARTICLE_NAME = ?, ARTICLE_CONTENT = ?, ARTICLE_SAMPLE_CONTENT = ?, "
				+ "ARTICLE_MAINPICTURE = ?, ARTICLE_NOTICE = ? WHERE ARTICLE_ID = ?";
		boolean result = false;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getArticleName());
			pstmt.setClob(2, dto.getArticleContent());
			pstmt.setString(3, dto.getArticleSampleContent());
			pstmt.setString(4, dto.getArticleMainPictureURL());
			pstmt.setInt(5, dto.getArticleNotice());
			pstmt.setInt(6, dto.getArticleId());
			int x = pstmt.executeUpdate();
			if (x < 1) {
				System.out.println("정상적으로 저장되지 않았습니다.");
			} else {
				result = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}