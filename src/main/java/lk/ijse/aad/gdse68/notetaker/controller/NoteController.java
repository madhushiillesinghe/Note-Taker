package lk.ijse.aad.gdse68.notetaker.controller;


import lk.ijse.aad.gdse68.notetaker.customObj.NoteResponse;
import lk.ijse.aad.gdse68.notetaker.exception.DataPersistFailedException;
import lk.ijse.aad.gdse68.notetaker.exception.NoteNotFound;
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


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNote(@RequestBody NoteDto note){
        if (note == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                noteService.saveNote(note);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
    @GetMapping(value = "/allnotes",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDto> getAllNotes(){
        return noteService.getAllNote();
    }
    @GetMapping(value = "/{noteId}",produces =MediaType.APPLICATION_JSON_VALUE )
    public NoteResponse getNote(@PathVariable("noteId") String noteId){
        return noteService.getSelectNote(noteId);
    }

    @PutMapping(value = "/{noteId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateNote(@PathVariable ("noteId") String noteId, @RequestBody NoteDto note) {
        try {
            noteService.updateNote(noteId, note);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoteNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    restfull widiyt karanne
    @DeleteMapping(value = "/{noteId}")
//    responsee entity is object using spring
    public ResponseEntity<String> deleteNote(@PathVariable ("noteId") String noteId) {
       return noteService.deleteNote(noteId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :new  ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    }
