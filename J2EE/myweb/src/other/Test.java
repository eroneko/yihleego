package other;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Test {

	public static void main(String[] args) {

		Thread myemail = new myEmail("491934639@qq.com", "¤ªĞ°Ä§¤·¤Ş¤¹£¡", "0£º25");

		myemail.start();
		System.out.println("·¢ËÍÍê³É");
	}
}
