package lk.ijse.aad.gdse68.notetaker.util;

import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;
import lk.ijse.aad.gdse68.notetaker.dto.UserDTO;
import lk.ijse.aad.gdse68.notetaker.entity.NoteEntity;
import lk.ijse.aad.gdse68.notetaker.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    //    mapping
    //    note detail
    public NoteDto convertToDTO(NoteEntity note){
        return modelMapper.map(note, NoteDto.class);
    }
    public NoteEntity convertToEntity(NoteDto note){
        return modelMapper.map(note, NoteEntity.class);
    }
    public List<NoteDto> convertToDTO(List<NoteEntity> notes){
        return modelMapper.map(notes,List.class);
    }
    //user mapping
    public UserDTO convertToUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public UserEntity convertToUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public List<UserDTO> convertToUserDTO(List<UserEntity> users){
        return modelMapper.map(users,List.class);
    }

}
