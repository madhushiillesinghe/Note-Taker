package lk.ijse.aad.gdse68.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.aad.gdse68.notetaker.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Override
    public String saveUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public boolean updateUser(String userId, UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean deleteUser(String noteId) {
        return false;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO getSelectUser(String noteId) {
        return null;
    }
}
