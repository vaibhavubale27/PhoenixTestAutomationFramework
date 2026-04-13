package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReaderUtil {

	public static <T> Iterator<T> loadJson(String filename,Class<T[]> clazz) {
		
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
		ObjectMapper objectMapper = new ObjectMapper();
		T[] classArray = null;
		List <T> userCredentialsList = null;
		try {
			classArray = objectMapper.readValue(input, clazz);
			userCredentialsList=Arrays.asList(classArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return userCredentialsList.iterator();

	}

}
