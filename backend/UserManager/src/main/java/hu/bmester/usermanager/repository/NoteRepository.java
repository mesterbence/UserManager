package hu.bmester.usermanager.repository;

import hu.bmester.usermanager.model.user.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Note save(Note note);
}
