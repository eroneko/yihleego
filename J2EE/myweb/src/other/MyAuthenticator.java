package other;

import javax.mail.*;

public class MyAuthenticator extends Authenticator {
	private String username;
	private String password;

	public MyAuthenticator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}
