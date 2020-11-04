package com.imooc.jdbc.service;

import com.imooc.jdbc.bean.Message;
import com.imooc.jdbc.dao.MessageDAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 消息Service
 *
 * @version 1.0
 */
public class MessageService {

    private MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    public boolean addMessage(Message message) {
        message.setCreateTime(new Date());
        try {
            return messageDAO.save(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 分页查询全部留言
     * @param page 当前页码
     * @param pageSize 每页记录数
     * @return
     */
    public List<Message> getMessages(int page, int pageSize) {
        return messageDAO.getMessages(page, pageSize);
    }

    /**
     * 计算所有留言数量
     * @return
     */
    public int countMessages() {
        try {
            return messageDAO.countMessages();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return 0;
    }

}
