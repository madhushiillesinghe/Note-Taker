package lk.ijse.aad.gdse68.notetaker.service;

import jakarta.transaction.Transactional;
import lk.ijse.aad.gdse68.notetaker.customObj.NoteErrorResponse;
import lk.ijse.aad.gdse68.notetaker.customObj.NoteResponse;
import lk.ijse.aad.gdse68.notetaker.dao.NoteDao;
import lk.ijse.aad.gdse68.notetaker.dto.NoteDto;
import lk.ijse.aad.gdse68.notetaker.entity.NoteEntity;
import lk.ijse.aad.gdse68.notetaker.exception.DataPersistFailedException;
import lk.ijse.aad.gdse68.notetaker.exception.NoteNotFound;
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
    public void saveNote(NoteDto noteDto) {
        noteDto.setNoteId(AppUtil.createNoteId());
        NoteEntity noteEntity = mapping.convertToEntity(noteDto);
        var noteSaved=noteDao.save(noteEntity);
//        noteDao.save(noteEntity);
//        return "Note saved in service layer";
        if (noteSaved == null){
            throw new DataPersistFailedException("can not save note");
        }

    }
    @Override
    public void updateNote(String noteId, NoteDto incomenoteDto) {
        Optional<NoteEntity> updateById=noteDao.findById(noteId);
        if(!updateById.isPresent()){
            throw new NoteNotFound("Note not found");
        }else {
            updateById.get().setNoteDecs(incomenoteDto.getNoteDecs());
            updateById.get().setNoteTitle(incomenoteDto.getNoteTitle());
            updateById.get().setCreateDate(incomenoteDto.getCreateDate());
            updateById.get().setPriorityLevel(incomenoteDto.getPriorityLevel());

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
    public NoteResponse getSelectNote(String noteId) {
        if(noteDao.existsById(noteId)){
            return mapping.convertToDTO(noteDao.getReferenceById(noteId));
        }else {
            return new NoteErrorResponse(0,"Note not found");
        }    }

    @Override
    public List<NoteDto> getAllNote() {
       return  mapping.convertToDTO(noteDao.findAll());
    }

}
