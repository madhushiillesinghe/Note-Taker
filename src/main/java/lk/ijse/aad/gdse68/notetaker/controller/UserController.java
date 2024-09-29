package lk.ijse.aad.gdse68.notetaker.controller;

import lk.ijse.aad.gdse68.notetaker.customObj.UserResponse;
import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;
import lk.ijse.aad.gdse68.notetaker.dto.UserDTO;
import lk.ijse.aad.gdse68.notetaker.entity.NoteEntity;
import lk.ijse.aad.gdse68.notetaker.exception.DataPersistFailedException;
import lk.ijse.aad.gdse68.notetaker.exception.UserNotFoundException;
import lk.ijse.aad.gdse68.notetaker.service.UserService;
import lk.ijse.aad.gdse68.notetaker.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        @RequestPart("profilepic") MultipartFile profilepic){

        try {
            String base64ProfilePic = AppUtil.toBase64Profilepic(profilepic);
            // build the user object
            UserDTO buildUserDTO = new UserDTO();
            buildUserDTO.setFirstName(firstName);
            buildUserDTO.setLastName(lastName);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(password);
            buildUserDTO.setProfilepic(base64ProfilePic);
            //send to the service layer
            userService.saveUser(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{userId}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void>  updateUser(@PathVariable("userId") String userId,
                                              @RequestPart("firstName") String firstName,
                                              @RequestPart("lastName") String lastName,
                                              @RequestPart("email") String email,
                                              @RequestPart("password") String password,
                                              @RequestPart("profilepic")MultipartFile profilepic){
        try {

            String base64ProfilePic = AppUtil.toBase64Profilepic(profilepic);
            UserDTO updateuserDTO = new UserDTO();
            updateuserDTO.setUserId(userId);
            updateuserDTO.setFirstName(firstName);
            updateuserDTO.setLastName(lastName);
            updateuserDTO.setEmail(email);
            updateuserDTO.setPassword(password);
            updateuserDTO.setProfilepic(base64ProfilePic);
            userService.updateUser(updateuserDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable ("userId") String userId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(value = "/allusers",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping(value = "/{userId}",produces =MediaType.APPLICATION_JSON_VALUE )
    public UserResponse getUser(@PathVariable("userId") String userId){
        return userService.getSelectUserBYId(userId);
    }
}
