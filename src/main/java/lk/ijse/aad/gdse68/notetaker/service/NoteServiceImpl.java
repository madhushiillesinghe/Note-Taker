package lk.ijse.aad.gdse68.notetaker.service;

import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;
import lk.ijse.aad.gdse68.notetaker.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class NoteServiceImpl implements NoteService {
    List <NoteDto> saveNoteTmp=new ArrayList<>();
    public NoteServiceImpl() {
        saveNoteTmp.add(new NoteDto("NOTE : 8ecfa465-8f75-4799-b31f-401453ca6b46", "AAD", "Hello Spring : This is a note", "L - 02", "2021-09-01"));
        saveNoteTmp.add(new NoteDto("NOTE : 8ecfa465-8f75-4799-b31f-401453ca6b47", "CS", "Hello Spring : This is a note", "L - 03", "2021-09-02"));
        saveNoteTmp.add(new NoteDto("NOTE : 8ecfa465-8f75-4799-b31f-401453ca6b48", "SE", "Hello Spring : This is a note", "L - 04", "2021-09-03"));
        System.out.println(saveNoteTmp+"25");
    }
    @Override
    public String saveNote(NoteDto noteDto) {
//        Todo: Handle with Bo
        noteDto.setNoteId(AppUtil.createNoteId());
        saveNoteTmp.add(noteDto);
        System.out.println(noteDto);
        return "Saved successfull in BO Layer";
    }

    @Override
    public void updateNote(String noteId, NoteDto incomenoteDto) {
        ListIterator<NoteDto> updateList=saveNoteTmp.listIterator();
        while (updateList.hasNext()){
            NoteDto noteDto=updateList.next();
            if (noteId.equals(noteDto.getNoteId())) {
                incomenoteDto.setNoteId(noteDto.getNoteId());
               updateList.set(incomenoteDto);
               break;
            }
        }

    }

    @Override
    public void deleteNote(String noteId) {
        ListIterator<NoteDto> deletedto=saveNoteTmp.listIterator();
        while (deletedto.hasNext()){
            NoteDto noteDto=deletedto.next();
            if (noteId.equals(noteDto.getNoteId())) {
                deletedto.remove();
                break;
            }
        }
    }
    @Override
    public NoteDto getSelectNote(String noteId) {
        for (NoteDto noteDto : saveNoteTmp) {
            if (noteDto.getNoteId().equals(noteId)) {
                return noteDto;
            }
        }
        return null;
    }
//    @Override
//    public NoteDto getNote(String noteId) {
//        System.out.println(noteId);
//        return new NoteDto(
//                "NOTE : 8ecfa465-8f75-4799-b31f-401453ca6b46",
//                "This is the first note",
//                "Hello Spring : This is a note",
//                "L - 02",
//                "2021-09-01"
//        );
//
//    }
    @Override
    public List<NoteDto> getAllNote() {
        return saveNoteTmp;
    }

}
