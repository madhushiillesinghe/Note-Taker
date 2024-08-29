package lk.ijse.aad.gdse68.notetaker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "notes")
@Entity
public class NoteEntity {
    @Id
    private String noteId;
    private String noteTitle;
    private String noteDecs;
    private String priorityLevel;
    private String createDate;
}
