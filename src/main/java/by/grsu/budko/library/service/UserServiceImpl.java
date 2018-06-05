package by.grsu.budko.library.service;

import by.grsu.budko.library.model.Role;
import by.grsu.budko.library.model.User;
import by.grsu.budko.library.repository.RoleRepository;
import by.grsu.budko.library.repository.UserRepository;
import by.grsu.budko.library.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	// encrypt user password and assign a role USER
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers(){ return userRepository.findAll(); }

	@Override
	public User getUserById(long id){ return userRepository.findOne(id); }
}
