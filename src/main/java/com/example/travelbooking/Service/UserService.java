package com.example.MobileStoreSystem.Service;

import com.example.MobileStoreSystem.entity.User;

public interface UserService {
	User loginuser(String userName, String password);
	 User addUser( User user);
	 User updateDb(String userName ,User user);
	void deleteDb(String userName);

}
