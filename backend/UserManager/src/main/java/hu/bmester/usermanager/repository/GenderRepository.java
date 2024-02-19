package hu.bmester.usermanager.repository;

import hu.bmester.usermanager.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
    Gender findGenderById(Long id);
}
