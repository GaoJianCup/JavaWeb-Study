package orm.mapper;

import orm.po.User;

public interface UserMapper {
	void registerUser(User user);
	
	int loginByUsernameAndPassword(User user);
}