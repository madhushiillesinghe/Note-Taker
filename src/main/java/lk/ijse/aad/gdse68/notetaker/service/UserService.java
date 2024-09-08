package lk.ijse.aad.gdse68.notetaker.service;

import lk.ijse.aad.gdse68.notetaker.customObj.UserResponse;
import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;
import lk.ijse.aad.gdse68.notetaker.dto.UserDTO;

import java.util.List;

public interface UserService {
    String saveUser(UserDTO userDTO);
    boolean updateUser(UserDTO userDTO);
    void deleteUser(String userId);
    List<UserDTO> getAllUsers();
    UserResponse getSelectUserBYId(String userId);
    UserDTO getSelectUser(String userId);
}
