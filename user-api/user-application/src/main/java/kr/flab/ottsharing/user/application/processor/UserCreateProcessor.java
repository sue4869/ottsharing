package kr.flab.ottsharing.user.application.processor;

import kr.flab.common.ottsharing.domain.EventPublisher;
import kr.flab.ottsharing.user.application.processor.response.EmailDTO;
import kr.flab.ottsharing.user.domain.UserV1;
import kr.flab.ottsharing.user.domain.event.UserRegistered;
import kr.flab.ottsharing.user.domain.exception.DuplicateEmailException;
import kr.flab.ottsharing.user.domain.repository.UserV1Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class UserCreateProcessor {

    private final UserV1Repository userV1Repository;

    private final EventPublisher eventPublisher;
    private static final Logger log = LoggerFactory.getLogger(EmailValidCheckTokenCreateProcessor.class);

    public UserCreateProcessor(UserV1Repository userV1Repository, EventPublisher eventPublisher) {
        this.userV1Repository = userV1Repository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public EmailDTO execute(Command command) {
        if (userV1Repository.existsByEmail(command.email)) {
            throw new DuplicateEmailException();
        }

        UserV1 newUserV1 = new UserV1(
                null,
                command.userName,
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

       return new EmailDTO(command.email);
    }

    public static class Command {

        private final String password;
        private final String userName;
        private final String email;

        public Command(String email, String userName, String password) {
            this.password = password;
            this.userName = userName;
            this.email = email;
        }
    }
}


