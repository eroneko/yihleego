package other;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Test {

	public static void main(String[] args) {

		Thread myemail = new myEmail("491934639@qq.com", "��аħ���ޤ���", "0��25");

		myemail.start();
		System.out.println("�������");
	}
}
