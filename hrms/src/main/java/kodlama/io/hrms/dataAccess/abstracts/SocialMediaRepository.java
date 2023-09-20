package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.SocialMedia;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, Integer> {
	
	List<SocialMedia> getSocialMediaByUserId(int id); 

}
