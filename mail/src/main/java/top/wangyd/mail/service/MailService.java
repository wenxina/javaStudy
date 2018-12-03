package top.wangyd.mail.service;

/**
 * @author wang
 * @date 2018年11月12日15:17:41
 */
public interface MailService {

    void sendSimpleMail(String to, String subject, String content);

    void sendHtmlMail(String to, String subject, String content);

    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

}
