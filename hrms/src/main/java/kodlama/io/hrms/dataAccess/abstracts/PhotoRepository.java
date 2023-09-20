package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Photo;

public interface PhotoRepository  extends JpaRepository<Photo, Integer>{
	
	Photo getPhotoByUserId(int id);
	

}
