package kr.flab.ottsharing.user.infrastructure.token.emailValidCheck;

import kr.flab.ottsharing.user.domain.TokenGenerator;
import org.springframework.stereotype.Component;

@Component
public class TokenGeneratorForEmailAdaptor implements TokenGenerator {

    private final MakeUUIDString makeUUIDString;

    public TokenGeneratorForEmailAdaptor(MakeUUIDString makeUUIDString) {
        this.makeUUIDString = makeUUIDString;
    }

    @Override
    public String generate() {
        return makeUUIDString.generate();
    }
}


