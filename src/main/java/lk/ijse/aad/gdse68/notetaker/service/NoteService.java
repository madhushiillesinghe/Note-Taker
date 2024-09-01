package lk.ijse.aad.gdse68.notetaker.service;

import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;

import java.util.List;

public interface NoteService {
    String saveNote(NoteDto noteDto);
   boolean updateNote(String noteId,NoteDto noteDto);
   boolean deleteNote(String noteId);
   // NoteDto getNote(String noteId);
    List<NoteDto> getAllNote();
    NoteDto getSelectNote(String noteId);
}
