package softuni.Mobilele.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import softuni.Mobilele.repository.UserRepository;

public class UniqueUserEmailValidator implements ConstraintValidator<UniqueUserName, String> {

    private final UserRepository userRepository;

    public UniqueUserEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userRepository
                .findByEmail(value)
                .isEmpty();
    }
}
