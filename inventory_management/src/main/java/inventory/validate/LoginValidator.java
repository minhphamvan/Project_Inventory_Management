package inventory.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import inventory.entity.User;

public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == User.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		ValidationUtils.rejectIfEmpty(errors, "username", "msg.required");
		ValidationUtils.rejectIfEmpty(errors, "password", "msg.required");

		// Kiem tra them
	}

}
