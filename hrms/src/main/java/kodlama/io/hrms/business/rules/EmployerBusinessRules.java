package kodlama.io.hrms.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.exceptions.BusinessException;
import kodlama.io.hrms.dataAccess.abstracts.EmployerRepository;
import kodlama.io.hrms.dataAccess.abstracts.EntityRepository;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class EmployerBusinessRules extends BusinessRules<Employer>{
	
	private EmployerRepository employerRepository;

	public EmployerBusinessRules(EmployerRepository employerRepository,EntityRepository<Employer> entityRepository) {
		super(entityRepository);
		this.employerRepository = employerRepository;
	}


	public void checkWebSiteDomain(String webSite,String email) {
		
		if(email.split("@")[0].equalsIgnoreCase(webSite.split("\\.")[1])== false) {
			
			throw new BusinessException("Email ile web site domaini aynı değil");
			
		} 
	}
	
	
	public void checkPasswordFields(String password,String confirmPassword) {
		
		if(password.equalsIgnoreCase(confirmPassword) == false) {
			throw new BusinessException("Şifreler Farklı");
		}

	}
	
	public void checkEmailIfExistsBefore(String email) {

		if(employerRepository.existsByEmail(email) == true) {
			throw new BusinessException("Böyle bir email sisteme kayıtlı");
		}else {
			return;
		}
		
	}

}
