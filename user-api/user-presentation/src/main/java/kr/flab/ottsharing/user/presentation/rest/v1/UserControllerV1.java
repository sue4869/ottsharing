package kr.flab.ottsharing.user.presentation.rest.v1;

import kr.flab.ottsharing.user.application.processor.UserCreateProcessor;
import kr.flab.ottsharing.user.presentation.rest.v1.request.UserCreateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/v1")
public class UserControllerV1 {

    private final UserCreateProcessor userCreateProcessor;

    public UserControllerV1(UserCreateProcessor userCreateProcessor) {
        this.userCreateProcessor = userCreateProcessor;
    }

    @PostMapping
    public void createUser(@RequestBody UserCreateRequest request) {
          userCreateProcessor.execute(request.toCommand());
    }
}

