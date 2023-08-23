package kodlama.io.hrms.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.exceptions.BusinessException;
import kodlama.io.hrms.dataAccess.abstracts.EntityRepository;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerRepository;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerBusinessRules extends BusinessRules<JobSeeker>{

	private JobSeekerRepository jobSeekerRepository;

	@Autowired
	public JobSeekerBusinessRules(JobSeekerRepository jobSeekerRepository,EntityRepository<JobSeeker> entityRepository) {
		super(entityRepository);
		this.jobSeekerRepository = jobSeekerRepository;
	}
	
	
	
	public void checkIdentityNumberExistsBefore(String identityNumber) {
		
		if(jobSeekerRepository.existsByIdentityNumber(identityNumber)== true) {
			throw new BusinessException("Böyle bir TC Kimlik numarası sisteme kayıtlı");
			
		}
		
		
		
	}
	
	
	

}
