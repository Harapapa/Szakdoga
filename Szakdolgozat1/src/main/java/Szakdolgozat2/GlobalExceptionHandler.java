package Szakdolgozat2;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFound.class)
	public String exceptionHandler(UserNotFound usernotfound) 
	{
		return "Nem található felhasználó" +usernotfound.getMessage();
	}
}
