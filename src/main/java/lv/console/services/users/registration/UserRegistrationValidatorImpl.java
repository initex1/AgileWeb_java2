package lv.console.services.users.registration;

import lv.console.database.UserRepository;
import lv.console.domain.User;
import lv.console.services.TaskListError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class UserRegistrationValidatorImpl implements UserRegistrationValidator {

    @Autowired private UserRepository userRepository;

    @Override
    public List<TaskListError> validate(UserRegistrationRequest request) {
        List<TaskListError> errors = new ArrayList<>();
        validateLogin(request.getLogin()).ifPresent(errors::add);
        validateDuplicateLogin(request.getLogin()).ifPresent(errors::add);
        validatePassword(request.getPassword()).ifPresent(errors::add);
        return errors;
    }

    private Optional<TaskListError> validateLogin(String login) {
        if (login == null || login.isEmpty()) {
            return Optional.of(new TaskListError("login", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<TaskListError> validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return Optional.of(new TaskListError("password", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<TaskListError> validateDuplicateLogin(String login) {
        if (login != null && !login.isEmpty()) {
            Optional<User> userOpt = userRepository.findByLogin(login);
            if (userOpt.isPresent()) {
                return Optional.of(new TaskListError("login", "Must not be repeated"));
            }
        }
        return Optional.empty();
    }

}