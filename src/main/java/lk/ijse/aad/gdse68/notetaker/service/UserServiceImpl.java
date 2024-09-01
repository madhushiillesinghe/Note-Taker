package lk.ijse.aad.gdse68.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.aad.gdse68.notetaker.dao.NoteDao;
import lk.ijse.aad.gdse68.notetaker.dao.UserDao;
import lk.ijse.aad.gdse68.notetaker.dto.UserDTO;
import lk.ijse.aad.gdse68.notetaker.entity.NoteEntity;
import lk.ijse.aad.gdse68.notetaker.entity.UserEntity;
import lk.ijse.aad.gdse68.notetaker.util.AppUtil;
import lk.ijse.aad.gdse68.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;
    @Override
    public String saveUser(UserDTO userDTO) {
        userDTO.setUserId(AppUtil.createUserId());

        userDao.save(mapping.convertToUserEntity(userDTO));
        return "User saved in service layer";

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
