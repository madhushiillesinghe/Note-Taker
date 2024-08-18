package lk.ijse.aad.gdse68.notetaker.controller;


import lk.ijse.aad.gdse68.notetaker.dto.Note;
import lk.ijse.aad.gdse68.notetaker.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/note")
public class NoteController {
//    Todo: CRUD of the note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody Note note){
        note.setNoteId(AppUtil.createNoteId());
        //    Todo: Post of the note
        System.out.println(note);
        return ResponseEntity.ok("Note created successful");
    }
}
