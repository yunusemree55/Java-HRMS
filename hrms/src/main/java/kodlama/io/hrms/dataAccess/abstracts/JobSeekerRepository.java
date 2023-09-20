package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer>, EntityRepository<JobSeeker> {
	
	
	boolean existsByIdentityNumber(String identityNumber);
	boolean existsByEmail(String email);
	JobSeeker getByEmail(String email);

}
