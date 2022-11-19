package kr.flab.ottsharing.user.domain;

import kr.flab.ottsharing.user.domain.exception.WeakPasswordException;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Password {

    private String password;
    @Transient
    private final int PASSWORD_MIN_LENGTH = 8;

    protected Password() {

    }

    public Password(String password) {

        if (isWeekPassword(password)) {
            throw new WeakPasswordException();
        }

        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    private boolean isWeekPassword(String password) {
        if (password.length() < PASSWORD_MIN_LENGTH) {
            return true;
        }
        if (!includesBothNumberAndAlphabet(password)) {
            return true;
        }
        return false;
    }

    private boolean includesBothNumberAndAlphabet(String str) {
        boolean includesNumber = false;
        boolean includesAlphabet = false;

        for (char ch : str.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                includesAlphabet = true;
            }
            if (Character.isDigit(ch)) {
                includesNumber = true;
            }
        }

        return includesAlphabet && includesNumber;
    }
}


