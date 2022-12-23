package kr.flab.ottsharing.user.infrastructure.token.emailValidCheck;

import kr.flab.ottsharing.user.domain.TokenGenerator;
import org.springframework.stereotype.Component;

@Component
public class TokenGeneratorForEmailAdaptor implements TokenGenerator {

    private final UUIDStringGenerator makeUUIDString;

    public TokenGeneratorForEmailAdaptor(UUIDStringGenerator uuidStringGenerator) {
        this.makeUUIDString = uuidStringGenerator;
    }

    @Override
    public String generate() {
        return makeUUIDString.generate();
    }
}


