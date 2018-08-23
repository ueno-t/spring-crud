package jp.scriptkidie.users.infrastructure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import jp.scriptkidie.users.domain.user.Name;
import jp.scriptkidie.users.domain.user.User;
import jp.scriptkidie.users.domain.user.UserType;
import jp.scriptkidie.users.infrastructure.entity.auditing.Audit;
import jp.scriptkidie.users.infrastructure.entity.auditing.AuditListener;
import jp.scriptkidie.users.infrastructure.entity.auditing.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@EntityListeners(AuditListener.class)
public class UserEntity implements Auditable {

	@Id
	@Column(name = "user_id")
	private String id;
	@Column(name = "user_type")
	private String userType;
	@Column(name = "user_name_kn")
	private String userNameKn;
	@Column(name = "user_name_kj")
	private String userNameKj;
	@Column(name = "birthday")
	private Date birthday;

    @Embedded
    private Audit audit;

    public static UserEntity of(User user) {
    	return UserEntity.builder()
    			.id(user.getId())
    			.userType(user.getType().code())
    			.userNameKn(user.getName().getNameKana())
    			.userNameKj(user.getName().getNameKanji())
    			.birthday(user.getBirthday())
    			.build();
    }

    public User toDomain() {
    	return User.builder()
    			.id(id)
    			.type(UserType.type(userType))
    			.name(Name.builder().nameKana(userNameKn).nameKanji(userNameKj).build())
    			.birthday(birthday)
    			.build();
    }
}
