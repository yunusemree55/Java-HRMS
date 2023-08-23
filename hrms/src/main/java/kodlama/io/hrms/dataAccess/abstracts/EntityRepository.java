package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.abstracts.User;

public interface EntityRepository<T extends User> extends JpaRepository<T, Integer> {

	boolean existsByEmail(String email);

}
