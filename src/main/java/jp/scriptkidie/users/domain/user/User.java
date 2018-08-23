package jp.scriptkidie.users.domain.user;

import java.util.Date;
import java.util.List;

import jp.scriptkidie.users.domain.user.address.Address;
import jp.scriptkidie.users.domain.user.contact.Contact;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {

	private String id;
	private UserType type;
	private Name name;
	private Date birthday;
	private Address address;
	private List<Contact> contacts;
}
