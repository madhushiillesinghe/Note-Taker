package lk.ijse.aad.gdse68.notetaker.dto;

import lk.ijse.aad.gdse68.notetaker.customObj.NoteResponse;
import lk.ijse.aad.gdse68.notetaker.customObj.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDto implements  SuperDTO, NoteResponse {
    private String noteId;
    private String noteTitle;
    private String noteDecs;
    private String priorityLevel;
    private String createDate;
    private String userId;
}
