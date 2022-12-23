package kr.flab.ottsharing.user.infrastructure.config;

import kr.flab.ottsharing.user.domain.TokenGenerator;
import kr.flab.ottsharing.user.infrastructure.token.emailValidCheck.TokenGeneratorForEmailAdaptor;
import kr.flab.ottsharing.user.infrastructure.token.emailValidCheck.UUIDStringGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidCheckEmailTokenGeneratorConfig {

    @Bean
    public TokenGenerator tokenGenerator(UUIDStringGenerator uuidStringGenerator){
        return new TokenGeneratorForEmailAdaptor(uuidStringGenerator);
    }
}


