package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {

	
	@Query("From JobAdvertisement Where status.name = 'Aktif' ")
	List<JobAdvertisement> getActiveJobAdvertisements();
	
	@Query("From JobAdvertisement Order By endingDate desc")
	List<JobAdvertisement> getJobAdvertisementByEndingDate();
	
	@Query("From JobAdvertisement Where employer.companyName = :companyName")
	List<JobAdvertisement> getJobAdvertisementByCompanyName(String companyName);
	
	
}
