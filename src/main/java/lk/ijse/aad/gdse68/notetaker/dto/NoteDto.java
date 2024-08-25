package lk.ijse.aad.gdse68.notetaker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDto {
    private String noteId;
    private String noteTitle;
    private String noteDecs;
    private String priorityLevel;
    private String createDate;
}
