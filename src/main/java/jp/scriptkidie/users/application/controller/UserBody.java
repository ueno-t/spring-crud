package jp.scriptkidie.users.application.controller;

import jp.scriptkidie.users.domain.user.Name;
import jp.scriptkidie.users.domain.user.User;
import jp.scriptkidie.users.domain.user.UserType;
import lombok.Data;

@Data
public class UserBody {

	private String id;
	private String userType;
	private String userNameKj;
	private String userNameKn;

	public User toDomain() {
		return User.builder()
				.id(id)
				.type(UserType.type(userType))
				.name(Name.builder().nameKana(userNameKj).nameKanji(userNameKj).build())
				.build();
	}
}
