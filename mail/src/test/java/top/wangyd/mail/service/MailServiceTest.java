package top.wangyd.mail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author wang
 * @date 2018年11月12日15:25:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 建伟邮箱地址   :   18234824640@163.com
     */
    @Test
    public void testSimpleMail() {
        mailService.sendSimpleMail("lizixuan@sinoprof.com","testSimpleMail","Hello! SpringBoot mail test!");
    }

    @Test
    public void testHtmlMail() {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封SpringBoot测试邮件!</h3>\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "------------------------来自我问这瓜保熟吗" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("lizixuan@sinoprof.com","testHtmlMail",content);
    }

    /**
     * 邮件附件绝对路径,相对路径均可
     */
    @Test
    public void sendAttachmentsMail() {
        String filePath="K:\\图片\\SpringBoot.txt";
        /**
         * 我子轩儿子的专属邮箱信息 lizixuan@sinoprof.com
         */
        mailService.sendAttachmentsMail("lizixuan@sinoprof.com", "sendAttachmentsMail", "有附件，请查收！", filePath);
    }


    @Test
    public void sendInlineResourceMail() {
        String rscId = "007";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "K:\\图片\\SpringBoot.jpg";

        mailService.sendInlineResourceMail("lizixuan@sinoprof.com", "sendInlineResourceMail", content, imgPath, rscId);
    }


    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "Hexo教程一");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("lizixuan@sinoprof.com","sendTemplateMail",emailContent);
    }

}
