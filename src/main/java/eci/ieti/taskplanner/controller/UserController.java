package eci.ieti.taskplanner.controller;

import eci.ieti.taskplanner.model.User;
import eci.ieti.taskplanner.services.TaskPlannerException;
import eci.ieti.taskplanner.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsersHandler() {
        try {
            return new ResponseEntity<>(userService.getUsersList(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsersByIdHandler(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(userService.getUser(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUserHandler(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createUserHandler(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.createUser(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserHandler(@PathVariable String id) {
        try {
            userService.removeUser(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login )
            throws ServletException
    {

        String jwtToken;

        if ( login.getUsername() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String username = login.getUsername();
        String password = login.getPassword();

        User user;
        try {
            user = userService.getUser(username);
        } catch (TaskPlannerException e) {
            throw new ServletException( "User username not found." );
        }

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }
        //
        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
                SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    public class Token
    {
        String accessToken;

        public Token( String accessToken )
        {
            this.accessToken = accessToken;
        }

        public String getAccessToken()
        {
            return accessToken;
        }

        public void setAccessToken( String access_token )
        {
            this.accessToken = access_token;
        }
    }

}
