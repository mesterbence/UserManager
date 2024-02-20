package hu.bmester.usermanager.service;

import hu.bmester.usermanager.model.user.Note;
import hu.bmester.usermanager.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }
}
