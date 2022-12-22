package kr.flab.ottsharing.user.infrastructure.token.emailValidCheck;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MakeUUIDString {

    public String generate() {
        return UUID.randomUUID().toString();
    }
}


