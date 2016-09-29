package other;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public  class MD5 {
	// MD5�����㷨,��������м���
	public String MD5Pass(String oldstr) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		byte[] oldbytes = oldstr.getBytes();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");// ��ȡ����
			md.update(oldbytes);// ��ʼ������
			byte[] newBytes = md.digest();// ���м����㷨
			char[] newStr = new char[32];
			for (int i = 0; i < 16; i++) {
				byte temp = newBytes[i];
				newStr[2 * i] = hexDigits[temp >>> 4 & 0xf];
				newStr[2 * i + 1] = hexDigits[temp & 0xf];

			}
			return new String(newStr);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}

	}
	public void main(String[] args){
		System.out.println(MD5Pass("1234567"));
	
	}
}


