package Security2.Security2.controller;
import Security2.Security2.model.Authentification;
import Security2.Security2.model.UserModel;
import Security2.Security2.service.UserService;
import Security2.Security2.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserService customerService;

    @PostMapping({"/olla/user"})
    public String welcomePage() {
        return "You have been logged in! Congrats!";
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserModel customer) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getName(),customer.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("You must enter the correct data to log in!", e);
        }

        final UserDetails userDetails = customerService.loadUserByUsername(customer.getName());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new Authentification(jwt));
    }

    @GetMapping("/getAllUsers")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{userId}")
    public UserModel getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/postUser")
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }

    @PutMapping("/updateUserById/{userId}")
    public void updateUser(@RequestBody UserModel userModel,@PathVariable Integer userId){
        userService.updateUser(userId,userModel);
    }
    @DeleteMapping("/deleteUserById/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);

    }

}
