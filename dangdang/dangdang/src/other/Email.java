package other;

import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Provider;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Email {
	public static boolean sendEmail(String address,String title,String text)throws AddressException, MessagingException {
		 if(title==null||text==null||address==null){
			 return false;
		 }
        String SMTP_MAIL_HOST = "smtp.qq.com"; // ���ʼ���������ַ������ȥ�����ʼ���ѯ
        String EMAIL_USERNAME = "491934639@qq.com";
        String EMAIL_PASSWORD = "ffvwpwglzgpabhdb";
        String TO_EMAIL_ADDRESS = address;
        /* ��������Ϣ */
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_MAIL_HOST);
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        /* ����Session */
        Session session = Session.getDefaultInstance(props, new MyAuthenticator(EMAIL_USERNAME, EMAIL_PASSWORD));
        /* �ʼ���Ϣ */
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL_USERNAME));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO_EMAIL_ADDRESS));
        message.setSubject(title);
        message.setText(text);

        // ����
        Transport.send(message);
        return true;
	}
	public void main(String[] args)  {
	/*	try {
			sendEmail("1106968896@qq.com","��аħ���ޤ���","�o�Zing");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }

}
