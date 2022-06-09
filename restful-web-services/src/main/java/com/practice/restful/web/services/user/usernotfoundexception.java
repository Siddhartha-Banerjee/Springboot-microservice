package com.practice.restful.web.services.user;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class usernotfoundexception extends RuntimeException {

	public usernotfoundexception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
