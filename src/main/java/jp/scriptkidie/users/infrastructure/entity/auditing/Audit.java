package jp.scriptkidie.users.infrastructure.entity.auditing;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Audit {

	@Column(name = "create_user_id")
	private String createUserId;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "update_user_id")
	private String updateUserId;
	@Column(name = "update_date")
	private Date updateDate;

}
