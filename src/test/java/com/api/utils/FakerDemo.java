package com.api.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerDemo {
	//we will be using faker library for out of fake test data creatiom..!!
	
	//we will create fake util that that uses faker library!
	
	public static void main(String[] args) {
		
		Faker faker=new Faker(new Locale("en_IND"));
		
		System.out.println(faker.name().firstName());
		System.out.println(faker.name().lastName());
		System.out.println(faker.address().city());
		System.out.println(faker.address().buildingNumber());
		System.out.println(faker.address().streetAddress());
		
		System.out.println(faker.number().digits(13));
		System.out.println(faker.numerify("9075######"));
		
		System.out.println(faker.internet().emailAddress());
		
		System.out.println(faker.phoneNumber().cellPhone());
		
		
		
	}

}
