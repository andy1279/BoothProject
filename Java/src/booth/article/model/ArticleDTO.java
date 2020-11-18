package booth.article.model;

import java.sql.Clob;

public class ArticleDTO {
	public enum searchMethod {
		SEARCH_BY_ARTICLE_NAME,
		SEARCH_BY_ARTICLE_CONTENT,
		SEARCH_BY_ARTICLE_USERID
	};
	private int articleId;
	private String articleName;
	private Clob articleContent;
	private String articleSampleContent;
	private String articleMainPictureURL;
	private String articleUserId;
	private int articleNotice;
	private int articleBoothId;
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public Clob getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(Clob articleContent) {
		this.articleContent = articleContent;
	}
	public String getArticleSampleContent() {
		return articleSampleContent;
	}
	public void setArticleSampleContent(String articleSampleContent) {
		this.articleSampleContent = articleSampleContent;
	}
	public String getArticleMainPictureURL() {
		return articleMainPictureURL;
	}
	public void setArticleMainPictureURL(String articleMainPictureURL) {
		this.articleMainPictureURL = articleMainPictureURL;
	}
	public String getArticleUserId() {
		return articleUserId;
	}
	public void setArticleUserId(String articleUserId) {
		this.articleUserId = articleUserId;
	}
	public int getArticleNotice() {
		return articleNotice;
	}
	public void setArticleNotice(int articleNotice) {
		this.articleNotice = articleNotice;
	}
	public int getArticleBoothId() {
		return articleBoothId;
	}
	public void setArticleBoothId(int articleBoothId) {
		this.articleBoothId = articleBoothId;
	}
	
}
