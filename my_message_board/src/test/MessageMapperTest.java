package test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import dbtools.SqlSessionTool;
import orm.mapper.MessageMapper;
import orm.po.Message;

public class MessageMapperTest {
	
	SqlSession sqlSession = SqlSessionTool.getSqlSession();
	MessageMapper messageMapper=sqlSession.getMapper(MessageMapper.class);

	@Test
	public void testInsertMessage() {
		try {
			Message message = new Message(2, new Date(), "weather", "It's nice day today!");
			messageMapper.insertMessage(message);
			SqlSessionTool.commit();
		} catch (Exception e) {
			e.printStackTrace();
			SqlSessionTool.rollback();
		}
	}

	@Test
	public void testListMessages() {
		try {
			List<Message> messages=messageMapper.listMessages();
//			System.out.println(messages);
			for (Message message : messages) {
				System.out.println(message.getUser());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
