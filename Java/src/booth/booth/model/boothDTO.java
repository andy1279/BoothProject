package booth.booth.model;

import java.sql.Blob;
import java.sql.Date;
import lombok.*;

@Setter @Getter
public class boothDTO {
	
	int boothId;
	String boothName;
	String boothInfo;
	Blob boothImage;
	String boothBoss;
	String boothInviteCode;
	int boothNeedsConfirm;
	Date boothBirth;
}
