package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.cvs.Cv;

public interface CvRepository extends JpaRepository<Cv, Integer>{
	
	//@Query("From Cv Order By Cv.graduationDate Desc")
	//List<GetAllCvWithJobSeekerResponse> getCvByGraduationDateDesc();

}
