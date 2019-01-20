package lv.initex.web.controller;

import lv.initex.console.services.users.get.GetUserRequest;
import lv.initex.console.services.users.get.GetUserResponse;
import lv.initex.console.services.users.get.GetUserService;
import lv.initex.console.services.users.registration.UserRegistrationRequest;
import lv.initex.console.services.users.registration.UserRegistrationResponse;
import lv.initex.console.services.users.registration.UserRegistrationService;
import lv.initex.web.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private GetUserService getUserService;

    @ResponseBody
    @PostMapping(value = "/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserRegistrationRequest request = new UserRegistrationRequest(
                userDTO.getLogin(), userDTO.getPassword()
        );
        UserRegistrationResponse response = userRegistrationService.register(request);
        userDTO.setId(response.getUserId());
        return ResponseEntity.ok(userDTO);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") Long userId) {
        GetUserRequest request = new GetUserRequest(userId);
        GetUserResponse response = getUserService.get(request);
        return new UserDTO(
                response.getUser().getId(),
                response.getUser().getLogin(),
                response.getUser().getPassword()
        );
    }

}