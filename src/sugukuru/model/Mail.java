package sugukuru.model;

import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

public class Mail {
	public String SendMail(HttpServletResponse response,String title,String message,String email){

		String rMessage = "";

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;

        try{
            out = response.getWriter();
            Properties property = new Properties();

            property.put("mail.smtp.host","smtp.gmail.com");

            //GmailのSMTPを使う場合
            property.put("mail.smtp.auth", "true");
            property.put("mail.smtp.starttls.enable", "true");
            property.put("mail.smtp.host", "smtp.gmail.com");
            property.put("mail.smtp.port", "587");
            property.put("mail.smtp.debug", "true");

            Session session = Session.getInstance(property, new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("yanagikouta0602@gmail.com", "kouta123");
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);

            InternetAddress toAddress = new InternetAddress(email, "登録者様");

            mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);

            InternetAddress fromAddress = new InternetAddress("sugukuru.com","Sugukuru運営");

            mimeMessage.setFrom(fromAddress);

            mimeMessage.setSubject(title, "ISO-2022-JP");

            mimeMessage.setText(message, "ISO-2022-JP");

            Transport.send(mimeMessage);

            rMessage = "送信しました";
        }
        catch(Exception e){
        	rMessage =  "送信に失敗しました";
        } finally{
        	out.close();
        }
        return rMessage;

	}
}
