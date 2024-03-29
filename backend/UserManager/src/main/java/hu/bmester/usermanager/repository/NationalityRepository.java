package hu.bmester.usermanager.repository;

import hu.bmester.usermanager.model.user.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalityRepository extends JpaRepository<Nationality, Long> {
    Nationality findNationalityById(Long id);
}
