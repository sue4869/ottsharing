package kr.flab.ottsharing.user.domain;

import kr.flab.ottsharing.user.domain.exception.DuplicateEmailException;
import kr.flab.ottsharing.user.domain.exception.InvalidEmailException;
import kr.flab.ottsharing.user.domain.repository.UserV1Repository;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.regex.Pattern;

@Embeddable
public class Email {

    private String email;
    @Transient
    private final Pattern VALID_EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    protected Email() {

    }

    public Email(String email) {

        if (!isValidEmail(email)) {
            throw new InvalidEmailException();
        }

        this.email = email;
    }

    private boolean isValidEmail(String email) {
        return VALID_EMAIL_PATTERN.matcher(email).matches();
    }

    public String getEmail() {
        return email;
    }
}


