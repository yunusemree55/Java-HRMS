package kodlama.io.hrms.business.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.exceptions.BusinessException;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobSeekerBusinesRules {
	
	private JobSeekerRepository jobSeekerRepository;
	
	public void checkPasswordFields(String password,String confirmPassword) {
		
		if(password.equalsIgnoreCase(confirmPassword) == false) {
			throw new BusinessException("Şifreler Farklı");
		}

	}
	
	public void checkEmailIfExistsBefore(String email) {
		
		if(jobSeekerRepository.existsByEmail(email) == true) {
			
			throw new BusinessException("Böyle bir email sisteme kayıtlı");
		}
		
	}
	
	public void checkEmailField(String email) {
		
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches() == false) {
			throw new BusinessException("Email regex ile doğrulanamadı");
		}
		 
	}
	
	public void checkIdentityNumberExistsBefore(String identityNumber) {
		
		if(jobSeekerRepository.existsByIdentityNumber(identityNumber)== true) {
			
			throw new BusinessException("Böyle bir TC Kimlik numarası sisteme kayıtlı");
			
		}
		
		
		
	}
	
	
	

}
