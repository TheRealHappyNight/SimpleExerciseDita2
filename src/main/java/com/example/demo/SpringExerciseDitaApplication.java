package com.example.demo;

import com.example.demo.models.Card;
import com.example.demo.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExerciseDitaApplication {

	public static void main(String[] args) {
		testPhase1();
		SpringApplication.run(SpringExerciseDitaApplication.class, args);
	}

	public static void testPhase1() {
		User user0 = new User("Alex", "Blaj", "Cernavoda");
		User user1 = new User("Alex", "Blaj", "Cernavoda");
		User user2 = new User("Alex", "Blaj", "Cernavoda");
		User user3 = new User("Alex", "Blaj", "Cernavoda");
		User user4 = new User("Alex", "Blaj", "Cernavoda");
		User user5 = new User("Alex", "Blaj", "Cernavoda");
		User user6 = new User("Alex", "Blaj", "Cernavoda");
		User user7 = new User("Alex", "Blaj", "Cernavoda");

		Card card0 = new Card(user0.getFullName());
		Card card1 = new Card(user0.getFullName());
		Card card2 = new Card(user0.getFullName());
		Card card3 = new Card(user0.getFullName());
		Card card4 = new Card(user0.getFullName());
		Card card5 = new Card(user0.getFullName());
		Card card6 = new Card(user0.getFullName());
		Card card7 = new Card(user0.getFullName());

		System.out.println(card0);
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
		System.out.println(card4);
		System.out.println(card5);
		System.out.println(card6);
		System.out.println(card7);

		System.out.println(user0);
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		System.out.println(user4);
		System.out.println(user5);
		System.out.println(user6);
		System.out.println(user7);
	}
}
