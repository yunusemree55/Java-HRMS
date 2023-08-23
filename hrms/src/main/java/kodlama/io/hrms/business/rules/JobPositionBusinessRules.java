package kodlama.io.hrms.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.exceptions.BusinessException;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobPositionBusinessRules {
	
	private JobPositionRepository jobPositionRepository;
	
	public void checkJobPositionIfExists(String name) {
		
		if(jobPositionRepository.existsByName(name)== true) {
			
			throw new BusinessException("Böyle bir iş pozisyonu sistemde kayıtlı");
		}
		
	}
	

}
