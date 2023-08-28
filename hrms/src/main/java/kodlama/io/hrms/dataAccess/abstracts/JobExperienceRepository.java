package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.cvs.JobExperience;

public interface JobExperienceRepository extends JpaRepository<JobExperience, Integer>{

}
