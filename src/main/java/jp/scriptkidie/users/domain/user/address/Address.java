package jp.scriptkidie.users.domain.user.address;

import lombok.Value;

@Value
public class Address {

	private String districtCode;
	private String townCode;
	private String chome;
	private String addressStrings;
	private Building building;
}
