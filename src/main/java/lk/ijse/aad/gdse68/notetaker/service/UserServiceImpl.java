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
import java.util.Optional;

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
        Optional<UserEntity> updateById=userDao.findById(userId);
        if(!updateById.isPresent()){
            return false;
        }else {
            updateById.get().setEmail(userDTO.getEmail());
            updateById.get().setPassword(userDTO.getPassword());
            updateById.get().setFirstName(userDTO.getFirstName());
            updateById.get().setLastName(userDTO.getLastName());
            updateById.get().setProfilepic(userDTO.getProfilepic());
            return true;
        }    }

    @Override
    public boolean deleteUser(String userId) {
        if(userDao.existsById(userId)){
            userDao.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDTO> getAllUsers() {

        return  mapping.convertToUserDTO(userDao.findAll());
    }

    @Override
    public UserDTO getSelectUser(String userId) {
        return mapping.convertToUserDTO(userDao.getReferenceById(userId));
    }
}
