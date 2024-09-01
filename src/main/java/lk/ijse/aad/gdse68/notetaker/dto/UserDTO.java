package lk.ijse.aad.gdse68.notetaker.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lk.ijse.aad.gdse68.notetaker.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilepic;
    private List<NoteEntity> notes;
}
