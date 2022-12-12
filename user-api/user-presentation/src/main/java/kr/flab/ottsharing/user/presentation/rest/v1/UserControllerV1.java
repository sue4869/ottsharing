package kr.flab.ottsharing.user.presentation.rest.v1;

import kr.flab.common.ottsharing.response.CommonApiResponse;
import kr.flab.ottsharing.user.application.processor.UserCreateProcessor;
import kr.flab.ottsharing.user.application.processor.response.EmailDTO;
import kr.flab.ottsharing.user.presentation.rest.v1.request.UserCreateRequest;
import kr.flab.ottsharing.user.presentation.rest.v1.response.UserRegisterResponse;
import org.springframework.http.ResponseEntity;
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
    public CommonApiResponse<UserRegisterResponse> createUser(@RequestBody UserCreateRequest request) {
          EmailDTO email = userCreateProcessor.execute(request.toCommand());
        return CommonApiResponse.success(new UserRegisterResponse(email));
    }
}

