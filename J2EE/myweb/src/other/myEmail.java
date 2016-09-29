package other;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class myEmail extends Thread {
	private String address;
	private String title;
	private String text;

	public myEmail(String address, String title, String text) {
		this.address = address;
		this.title = title;
		this.text = text;
	}

	public void run() {
		if (title == null || text == null || address == null) {
			return;
		}

		String EMAIL_USERNAME = "yihleego@hotmail.com";
		String EMAIL_PASSWORD = "yeweiyi1994";
		String TO_EMAIL_ADDRESS = address;
		/* ��������Ϣ */
		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp-mail.outlook.com");
		props.put("mail.smtp.starttls.enable", "true");// ʹ�� STARTTLS��ȫ����
		props.put("mail.smtp.port", "25"); // googleʹ��465��587�˿�
		props.put("mail.smtp.auth", "true"); // ʹ����֤
		// props.put("mail.debug", "true");

		/*
		 * props.setProperty("mail.transport.protocol","SMTP");
		 * props.setProperty("mail.smtp.host", "smtp-mail.outlook.com"); //
		 * props.setProperty("mail.smtp.starttls.enable","true");
		 * props.setProperty("mail.smtp.auth", "true");
		 * 
		 * props.setProperty("mail.smtp.port", "25");
		 * props.put("mail.smtp.socketFactory.port", "587");
		 * props.setProperty("mail.smtp.socketFactory.class",
		 * "javax.net.ssl.SSLSocketFactory");
		 * props.setProperty("mail.starttls.enable","true");
		 * props.setProperty("mail.smtp.socketFactory.fallback", "false");
		 * props.setProperty("mail.smtp.quitwait","false");
		 */

		/* ����Session */
		Session session = Session.getDefaultInstance(props,
				new MyAuthenticator(EMAIL_USERNAME, EMAIL_PASSWORD));
		/* �ʼ���Ϣ */
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(EMAIL_USERNAME));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					TO_EMAIL_ADDRESS));
			message.setSubject(title);
			message.setText(text);
			// ����
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
