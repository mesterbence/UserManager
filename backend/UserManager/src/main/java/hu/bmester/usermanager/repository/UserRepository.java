package hu.bmester.usermanager.repository;

import hu.bmester.usermanager.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
