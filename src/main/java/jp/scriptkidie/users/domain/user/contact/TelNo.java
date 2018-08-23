package jp.scriptkidie.users.domain.user.contact;

import lombok.Value;

@Value
public class TelNo implements Contact {

	private ContactType TYPE = ContactType.TELNO;
	private int no;
	private String value;

	@Override
	public int no() {
		return no;
	}

	@Override
	public String value() {
		return value;
	}

}
