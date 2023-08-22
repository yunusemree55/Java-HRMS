package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {
	
	boolean existsByEmail(String email);
	boolean existsByIdentityNumber(String identityNumber);

}
