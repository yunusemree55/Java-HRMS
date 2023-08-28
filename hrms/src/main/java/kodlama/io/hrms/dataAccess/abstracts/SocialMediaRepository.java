package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.cvs.SocialMedia;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, Integer> {
	

}
