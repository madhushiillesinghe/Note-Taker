package lk.ijse.aad.gdse68.notetaker.controller;

import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;
import lk.ijse.aad.gdse68.notetaker.dto.UserDTO;
import lk.ijse.aad.gdse68.notetaker.entity.NoteEntity;
import lk.ijse.aad.gdse68.notetaker.service.UserService;
import lk.ijse.aad.gdse68.notetaker.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createUser(
        @RequestPart("firstName") String firstName,
        @RequestPart("lastName") String lastName,
        @RequestPart("email") String email,
        @RequestPart("password") String password,
        @RequestPart("profilepic")String profilepic){

        //Handle profile picture
        String base64ProfilePic= AppUtil.toBase64Profilepic(profilepic);
        //build the user object
        UserDTO builduserDTO=new UserDTO();
        builduserDTO.setFirstName(firstName);
        builduserDTO.setLastName(lastName);
        builduserDTO.setEmail(email);
        builduserDTO.setPassword(password);
        builduserDTO.setProfilepic(base64ProfilePic);
//        send to the service layer
        return new ResponseEntity<>(userService.saveUser(builduserDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String>  updateUser(@PathVariable("userId") String userId, @RequestPart("firstName") String firstName,
                                              @RequestPart("lastName") String lastName,
                                              @RequestPart("email") String email,
                                              @RequestPart("password") String password,
                                              @RequestPart("profilepic")String profilepic){
        String base64ProfilePic= AppUtil.toBase64Profilepic(profilepic);

        UserDTO updateuserDTO=new UserDTO();
        updateuserDTO.setFirstName(firstName);
        updateuserDTO.setLastName(lastName);
        updateuserDTO.setEmail(email);
        updateuserDTO.setPassword(password);
        updateuserDTO.setProfilepic(base64ProfilePic);
        return userService.updateUser(userId, updateuserDTO) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable ("userId") String userId) {
        return userService.deleteUser(userId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :new  ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    @GetMapping(value = "/allusers",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping(value = "/{userId}",produces =MediaType.APPLICATION_JSON_VALUE )
    public UserDTO getUser(@PathVariable("userId") String userId){
        return userService.getSelectUser(userId);
    }
}
