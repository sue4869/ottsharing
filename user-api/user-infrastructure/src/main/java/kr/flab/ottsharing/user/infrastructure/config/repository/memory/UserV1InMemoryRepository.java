package kr.flab.ottsharing.user.infrastructure.config.repository.memory;

import kr.flab.ottsharing.user.domain.UserV1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserV1InMemoryRepository {

    private final Map<Long, UserV1> memory = new HashMap<>();

    public UserV1 save(UserV1 user) {
        return memory.put(1L, user);
    }

    //1108
    public boolean existsByEmail(String email) {
        if(Optional.ofNullable(memory.get(email)) == null) return false;
        return true;
    }
}

