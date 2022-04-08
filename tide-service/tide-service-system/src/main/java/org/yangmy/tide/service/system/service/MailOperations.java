package org.yangmy.tide.service.system.service;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
public interface MailOperations {

    void sendMessage(String to,String subject,String text);

    void sendHtml();
}
