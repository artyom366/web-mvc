package lv.test.app.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

/**
 * Created by artyom on 15.6.11.
 */

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidEmailImpl.class)
public @interface ValidEmail {

    String message() default "This does not appear to be a valid email address";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};

    int min() default 5;
}
