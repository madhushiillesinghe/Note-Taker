package lk.ijse.aad.gdse68.notetaker.controller;


import lk.ijse.aad.gdse68.notetaker.service.NoteService;
import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
@RequiredArgsConstructor
public class NoteController {

    @Autowired
    private final NoteService noteService;
//    Todo: CRUD of the note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDto note){
        var  saveData=noteService.saveNote(note);
        return ResponseEntity.ok(saveData);
    }
    @GetMapping(value = "/allnotes",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDto> getAllNotes(){
        return noteService.getAllNote();
    }
    @GetMapping(value = "/{noteId}",produces =MediaType.APPLICATION_JSON_VALUE )
    public NoteDto getNote(@PathVariable("noteId") String noteId){
        return noteService.getSelectNote(noteId);
    }

    @PutMapping(value = "/{noteId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  updateNote(@PathVariable("noteId") String noteId, @RequestBody NoteDto noteDto){
        return noteService.updateNote(noteId,noteDto) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    restfull widiyt karanne
    @DeleteMapping(value = "/{noteId}")
//    responsee entity is object using spring
    public ResponseEntity<String> deleteNote(@PathVariable ("noteId") String noteId) {
       return noteService.deleteNote(noteId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :new  ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    }
