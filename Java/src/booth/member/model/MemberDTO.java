package booth.member.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MemberDTO {
	private String userId;
	private String userPw;
	private String userNick;
	private String userPhoneNum;
	private String userEmail;
}

