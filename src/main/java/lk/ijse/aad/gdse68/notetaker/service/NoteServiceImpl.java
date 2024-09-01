package lk.ijse.aad.gdse68.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.aad.gdse68.notetaker.dao.NoteDao;
import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;
import lk.ijse.aad.gdse68.notetaker.entity.NoteEntity;
import lk.ijse.aad.gdse68.notetaker.util.AppUtil;
import lk.ijse.aad.gdse68.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
    @Autowired
   private NoteDao noteDao;
    @Autowired
    private Mapping mapping;
    @Override
    public String saveNote(NoteDto noteDto) {
        noteDto.setNoteId(AppUtil.createNoteId());
        NoteEntity noteEntity = mapping.convertToEntity(noteDto);
        noteDao.save(noteEntity);
        return "Note saved in service layer";
    }

    @Override
    public boolean updateNote(String noteId, NoteDto incomenoteDto) {
        return false;
    }

    @Override
    public void deleteNote(String noteId) {
    noteDao.deleteById(noteId);
    }
    @Override
    public NoteDto getSelectNote(String noteId) {
    return mapping.convertToDTO(noteDao.getReferenceById(noteId));
    }

    @Override
    public List<NoteDto> getAllNote() {
       return  mapping.convertToDTO(noteDao.findAll());
    }

}
