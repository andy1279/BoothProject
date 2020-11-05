package booth.booth.model;

import java.sql.Date;

public class boothDTO {
	private int boothId;
	private String boothName;
	private String boothInfo;
	private String boothImage;
	private String boothBoss;
	private String boothInviteCode;
	private int boothNeedsConfirm;
	private Date boothBirth;
	public int getBoothId() {
		return boothId;
	}
	public void setBoothId(int boothId) {
		this.boothId = boothId;
	}
	public String getBoothName() {
		return boothName;
	}
	public void setBoothName(String boothName) {
		this.boothName = boothName;
	}
	public String getBoothInfo() {
		return boothInfo;
	}
	public void setBoothInfo(String boothInfo) {
		this.boothInfo = boothInfo;
	}
	public String getBoothImage() {
		return boothImage;
	}
	public void setBoothImage(String boothImage) {
		this.boothImage = boothImage;
	}
	public String getBoothBoss() {
		return boothBoss;
	}
	public void setBoothBoss(String boothBoss) {
		this.boothBoss = boothBoss;
	}
	public String getBoothInviteCode() {
		return boothInviteCode;
	}
	public void setBoothInviteCode(String boothInviteCode) {
		this.boothInviteCode = boothInviteCode;
	}
	public int getBoothNeedsConfirm() {
		return boothNeedsConfirm;
	}
	public void setBoothNeedsConfirm(int boothNeedsConfirm) {
		this.boothNeedsConfirm = boothNeedsConfirm;
	}
	public Date getBoothBirth() {
		return boothBirth;
	}
	public void setBoothBirth(Date boothBirth) {
		this.boothBirth = boothBirth;
	}
	
	
}
