package by.grsu.budko.library.service;

import by.grsu.budko.library.model.User;

import java.util.List;


public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public List<User> getAllUsers();
	public User getUserById(long id);
}
