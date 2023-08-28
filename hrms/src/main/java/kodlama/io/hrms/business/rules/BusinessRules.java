package kodlama.io.hrms.business.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.exceptions.BusinessException;
import kodlama.io.hrms.dataAccess.abstracts.EntityRepository;
import kodlama.io.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BusinessRules<T extends User> extends EntityBusinessRules implements CommonBusinessRules {
	
	private EntityRepository<T> entityRepository;
	
	@Override
	public void checkPasswordFields(String password,String confirmPassword) {
		
		if(password.equalsIgnoreCase(confirmPassword) == false) {
			throw new BusinessException("Şifreler Farklı");
		}

	}
	 
	@Override
	public void checkEmailIfExistsBefore(String email) {

		if(entityRepository.existsByEmail(email) == true) {
			throw new BusinessException("Böyle bir email sisteme kayıtlı");
		}else {
			return;
		}
		
	}

	@Override
	public void checkEmailField(String email) {
		
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches() == false) {
			throw new BusinessException("Email regex ile doğrulanamadı");
		}
		 
	}

}
