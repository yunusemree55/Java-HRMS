package kodlama.io.hrms.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.exceptions.BusinessException;
import kodlama.io.hrms.dataAccess.abstracts.CityRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityBusinessRules {
	
	private CityRepository cityRepository;
	
	public void checkCityNameIfExists(String name) {
		
		if(cityRepository.existsByName(name) == true) {
			
			throw new BusinessException("Böyle bir şehir sisteme kayıtlı");
			
		}
		
	}
	
	

}
