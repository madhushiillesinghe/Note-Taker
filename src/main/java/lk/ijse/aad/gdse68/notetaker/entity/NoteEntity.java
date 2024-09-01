package lk.ijse.aad.gdse68.notetaker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "notes")
@Entity
public class NoteEntity implements SuperEntity {
    @Id
    private String noteId;
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private UserEntity users;
    private String noteTitle;
    private String noteDecs;
    private String priorityLevel;
    private String createDate;

}
