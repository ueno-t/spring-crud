package jp.scriptkidie.users.infrastructure.entity.auditing;

public class AuditUser {

	private static final ThreadLocal<String> userHolder = new ThreadLocal<>();

	public static void set(String user) {
		userHolder.set(user);
	}

	public static void remove() {
		userHolder.remove();
	}

	public static String get() {
		return userHolder.get();
	}
}
