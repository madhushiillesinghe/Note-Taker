package lk.ijse.aad.gdse68.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.aad.gdse68.notetaker.dao.NoteDao;
import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;
import lk.ijse.aad.gdse68.notetaker.entity.NoteEntity;
import lk.ijse.aad.gdse68.notetaker.util.AppUtil;
import lk.ijse.aad.gdse68.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<NoteEntity> updateById=noteDao.findById(noteId);
        if(!updateById.isPresent()){
            return false;
        }else {
            updateById.get().setNoteDecs(incomenoteDto.getNoteDecs());
            updateById.get().setNoteTitle(incomenoteDto.getNoteTitle());
            updateById.get().setCreateDate(incomenoteDto.getCreateDate());
            updateById.get().setPriorityLevel(incomenoteDto.getPriorityLevel());
        return true;
        }
    }

    @Override
    public boolean deleteNote(String noteId) {
        if(noteDao.existsById(noteId)){
            noteDao.deleteById(noteId);
            return true;
        }
        return false;
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
