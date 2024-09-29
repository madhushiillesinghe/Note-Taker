package lk.ijse.aad.gdse68.notetaker.service;

import lk.ijse.aad.gdse68.notetaker.customObj.NoteResponse;
import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDto noteDTO);
    void updateNote(String noteId,NoteDto noteDto);
    void deleteNote(String noteId);
   // NoteDto getNote(String noteId);
    List<NoteDto> getAllNote();
    NoteResponse getSelectNote(String noteId);
}
