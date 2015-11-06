package lv.test.app.validator;


import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by artyom on 15.6.11.
 */
public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {

    private int min;


    @Override
    public void initialize(ValidEmail validEmail) {
        min = validEmail.min();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        if (email.length() <= min) {
            return false;
        } else if (!EmailValidator.getInstance(false).isValid(email)) {
            return false;
        }

        return true;
    }
}
