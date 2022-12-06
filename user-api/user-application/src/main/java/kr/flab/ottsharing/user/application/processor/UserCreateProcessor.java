package kr.flab.ottsharing.user.application.processor;

import kr.flab.common.ottsharing.domain.EventPublisher;
import kr.flab.ottsharing.user.domain.UserV1;
import kr.flab.ottsharing.user.domain.event.UserRegistered;
import kr.flab.ottsharing.user.domain.exception.DuplicateEmailException;
import kr.flab.ottsharing.user.domain.repository.UserV1Repository;
import org.springframework.transaction.annotation.Transactional;

public class UserCreateProcessor {

    private final UserV1Repository userV1Repository;

    private final EventPublisher eventPublisher;

    public UserCreateProcessor(UserV1Repository userV1Repository, EventPublisher eventPublisher) {
        this.userV1Repository = userV1Repository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public void execute(Command command) {

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
       eventPublisher.publish(
               new UserRegistered(
                       newUserV1.getId(),
                       newUserV1.getEmail().getEmail()

               )
       );
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

