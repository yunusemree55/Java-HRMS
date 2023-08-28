package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.cvs.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
