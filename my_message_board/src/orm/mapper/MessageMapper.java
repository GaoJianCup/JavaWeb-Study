package orm.mapper;

import java.util.List;

import orm.po.Message;


public interface MessageMapper {
	void insertMessage(Message message);
	List<Message> listMessages();
}