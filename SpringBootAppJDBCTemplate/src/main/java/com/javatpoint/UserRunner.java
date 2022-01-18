package com.javatpoint;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.javatpoint.model.User;
import com.javatpoint.service.UserService;

@Component
public class UserRunner implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Override

	public void run(String... args) throws Exception {

		/*
		 * try { User user1 = new User("Navya", "Kannada", 15000L); User user2 = new
		 * User("Kamxi", "Science", 55000L); User user3 = new User("preeti", "Social",
		 * 35000L); User user4 = new User("Chaitanya Warad", "english", 5000L);
		 * userService.insertUsers(Arrays.asList(user1, user2, user3, user4)); } catch
		 * (RuntimeException exception) { System.out.println("Excetion throwing....." +
		 * exception.getMessage()); }
		 */

		try {
			User user1 = new User("Navya", "Kannada", 15000L);
			User user2 = new User("Kamxi", "Science", 55000L);

			userService.insertUsers(Arrays.asList(user1, user2));
		} catch (RuntimeException exception) {
			System.out.println("Excetion throwing....." + exception.getMessage());
		}

		try {
			User user3 = new User("preeti", "Social", 35000L);
			User user4 = new User("Chaitanya Warad", "english", 5000L);
			userService.insertUsers(Arrays.asList(user3, user4));
		} catch (RuntimeException exception) {
			System.out.println("Excetion throwing....." + exception.getMessage());
		}

		System.out.println(userService.getAllUsersLambda());
	}

}
