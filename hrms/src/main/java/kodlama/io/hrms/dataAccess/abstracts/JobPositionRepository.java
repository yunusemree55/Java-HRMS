package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobPosition;

public interface JobPositionRepository extends JpaRepository<JobPosition, Integer>{
	
	boolean existsByName(String name);

}
