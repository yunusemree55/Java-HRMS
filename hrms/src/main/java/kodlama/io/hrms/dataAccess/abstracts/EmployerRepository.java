package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer>,EntityRepository<Employer>{

}
