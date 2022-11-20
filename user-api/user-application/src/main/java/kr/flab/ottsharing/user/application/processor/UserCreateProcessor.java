package kr.flab.ottsharing.user.application.processor;

import kr.flab.ottsharing.user.domain.UserV1;
import kr.flab.ottsharing.user.domain.exception.DuplicateEmailException;
import kr.flab.ottsharing.user.domain.repository.UserV1Repository;
import org.springframework.transaction.annotation.Transactional;

public class UserCreateProcessor {

    private final UserV1Repository userV1Repository;

    public UserCreateProcessor(UserV1Repository userV1Repository) {
        this.userV1Repository = userV1Repository;
    }

    @Transactional
    public void register(Command command) {

        if (userV1Repository.existsByEmail(command.email)) {
            throw new DuplicateEmailException();
        }

        UserV1 newUserV1 = new UserV1(
                null,
                command.email,
                command.password,
                null,
                null
        );

        userV1Repository.save(newUserV1);
    }

    public static class Command {

        private final String password;
        private final String email;

        public Command(String email, String password) {
            this.password = password;
            this.email = email;
        }
    }
}

