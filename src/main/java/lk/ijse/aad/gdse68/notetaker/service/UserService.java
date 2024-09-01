package lk.ijse.aad.gdse68.notetaker.service;

import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;
import lk.ijse.aad.gdse68.notetaker.dto.UserDTO;

import java.util.List;

public interface UserService {
    String saveUser(UserDTO userDTO);
    boolean updateUser(String userId,UserDTO userDTO);
    boolean deleteUser(String noteId);
    List<UserDTO> getAllUsers();
    UserDTO getSelectUser(String noteId);
}
