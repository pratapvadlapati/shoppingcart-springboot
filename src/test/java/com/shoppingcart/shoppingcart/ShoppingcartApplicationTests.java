package com.shoppingcart.shoppingcart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.jayway.jsonpath.Option;
import com.shoppingcart.shoppingcart.model.User;
import com.shoppingcart.shoppingcart.repository.UserRepository;
import com.shoppingcart.shoppingcart.service.UserService;

import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShoppingcartApplicationTests {

	// @Test
	void contextLoads() {
	}

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test

	public void saveUser() {
		User user = new User("pratap", "pratap@gmail.com", "p@456");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.saveUser(user));
	}

	@Test
	public void getUserById() {
		Long id = 1L;
		User user = new User("pratap", "pratap@gmail.com", "p@456");
		Optional<User> returnedUser = Optional.of(user);
		when(userRepository.findById(id)).thenReturn(returnedUser);
		assertEquals(true, userService.getUserById(id).isPresent());
	}

}
