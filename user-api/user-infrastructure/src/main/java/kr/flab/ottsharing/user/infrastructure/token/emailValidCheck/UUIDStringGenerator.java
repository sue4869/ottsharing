package kr.flab.ottsharing.user.infrastructure.token.emailValidCheck;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDStringGenerator {

    public String generate() {
        return UUID.randomUUID().toString();
    }
}


