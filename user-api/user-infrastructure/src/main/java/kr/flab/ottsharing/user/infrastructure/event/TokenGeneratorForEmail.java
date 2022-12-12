package kr.flab.ottsharing.user.infrastructure.event;

import kr.flab.ottsharing.user.domain.TokenGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenGeneratorForEmail implements TokenGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}


