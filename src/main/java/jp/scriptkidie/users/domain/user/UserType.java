package jp.scriptkidie.users.domain.user;

public enum UserType {
	INDIVIDUAL("1"),
	CORPORATE("2"),
	UNDFINED("3"),
	;

	private final String code;
	private UserType(final String code) {
		this.code = code;
	}

	public String code() {
		return code;
	}

	public static UserType type(String code) {
		for (UserType t : values()) {
			if (code.equals(t.code())) return t;
		}
		throw new IllegalArgumentException(code);
	}
}
