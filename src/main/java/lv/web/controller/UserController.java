package lv.web.controller;

import lv.console.services.users.get.GetUserRequest;
import lv.console.services.users.get.GetUserResponse;
import lv.console.services.users.get.GetUserService;
import lv.console.services.users.registration.UserRegistrationRequest;
import lv.console.services.users.registration.UserRegistrationResponse;
import lv.console.services.users.registration.UserRegistrationService;
import lv.web.dtos.UserDTO;
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
    @PostMapping(value = "/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserRegistrationRequest request = new UserRegistrationRequest(
                userDTO.getLogin(), userDTO.getPassword()
        );
        UserRegistrationResponse response = userRegistrationService.register(request);
        userDTO.setId(response.getUserId());
        return ResponseEntity.ok(userDTO);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
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