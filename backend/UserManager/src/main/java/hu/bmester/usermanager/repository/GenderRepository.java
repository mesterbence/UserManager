package hu.bmester.usermanager.repository;

import hu.bmester.usermanager.model.user.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
    Gender findGenderById(Long id);
}
