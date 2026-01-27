package com.vortech.shapebuddybackend.Controllers;


import com.vortech.shapebuddybackend.Config.RandomTokenGenerator;
import com.vortech.shapebuddybackend.Entity.User;
import com.vortech.shapebuddybackend.Service.UserService;
import com.vortech.shapebuddybackend.dtos.LoginDTO;
import com.vortech.shapebuddybackend.dtos.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private UserService service;

    AuthController(UserService service) {
        this.service = service;
    }

//    @Autowired
//    TokenGenerator tokenGenerator;


    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody SignupDTO signupDTO) {
//        try {
        System.out.println("hi");
        System.out.println(signupDTO.getUsername());
        System.out.println(signupDTO.getPassword());
        User user = new User();
        user.setUsername(signupDTO.getUsername());
        user.setPassword(signupDTO.getPassword());
        String s = new RandomTokenGenerator().generateToken();
        user.setToken(s);
        this.service.save(user);

//            Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(user, signupDTO.getPassword(), Collections.EMPTY_LIST);
//            user.setToken(TokenGenerator
//                    .createToken(authentication).getAccessToken());
//            this.service.save(user);
//            return ResponseEntity
//                    .ok(TokenGenerator
//                            .createToken(authentication));
//        } catch (UsernameNotFoundException ex) {
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body("Error: Username not found!");
//        } catch (BadCredentialsException ex) {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body("Error: Bad credentials!");
//        } catch (DataIntegrityViolationException ex) {
//            return ResponseEntity
//                    .status(HttpStatus.CONFLICT)
//                    .body("Error: Username may already exist!");
//        } catch (Exception ex) {
//            return ResponseEntity
//                    .internalServerError()
//                    .body("Error: An unexpected error occurred. Please try again later.");
//        }

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        User user = service.loginUser(loginDTO.getUsername(), loginDTO.getPassword());
        String s = new RandomTokenGenerator().generateToken();
        user.setToken(s);
        service.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
//        try {
//            try {
//                ;
//                Authentication authentication = UsernamePasswordAuthenticationToken
//                        .authenticated(service.loginUser(loginDTO.getUsername(), loginDTO.getPassword()),
//                                loginDTO.getPassword(), Collections.EMPTY_LIST);
//                User user = service.loginUser(loginDTO.getUsername(), loginDTO.getPassword());
//                user.setToken(TokenGenerator.createToken(authentication).getAccessToken());
//                this.service.save(user);
//                return ResponseEntity.ok(tokenGenerator.createToken(authentication));
//            } catch (Exception ex) {
//                return ResponseEntity.internalServerError().body("Error: An unexpected error occurred. Please try again later.");
//            }
//        } catch (AuthenticationException ex) {
//            throw new BadCredentialsException("Invalid username or password", ex);
//        } catch (Exception ex) {
//            return ResponseEntity.internalServerError().body("Error: An unexpected error occurred. Please try again later.");
//        }
    }


}
