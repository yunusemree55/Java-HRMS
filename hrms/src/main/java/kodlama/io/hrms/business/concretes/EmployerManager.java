package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.requests.employerRequests.AddEmployerRequest;
import kodlama.io.hrms.business.responses.employerResponses.GetAllEmployerResponse;
import kodlama.io.hrms.business.responses.employerResponses.GetEmployerResponse;
import kodlama.io.hrms.business.rules.EmployerBusinessRules;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.core.utilities.verifications.EmailVerificationService;
import kodlama.io.hrms.dataAccess.abstracts.EmployerRepository;
import kodlama.io.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService {
	
	private EmployerRepository employerRepository;
	private ModelMapperService modelMapperService;
	private EmployerBusinessRules employerBusinessRules;
	private EmailVerificationService emailVerificationService;
	

	@Override
	public List<GetAllEmployerResponse> getAll() {
		
		List<GetAllEmployerResponse> employerResponseList = employerRepository.findAll()
				.stream().map(employer -> modelMapperService.forResponse().map(employer, GetAllEmployerResponse.class)).collect(Collectors.toList());
		
		
		return employerResponseList;
		
		
	}


	@Override
	public void add(AddEmployerRequest addEmployerRequest) {
		
		employerBusinessRules.checkEmailIfExistsBefore(addEmployerRequest.getEmail());
		employerBusinessRules.checkEmailField(addEmployerRequest.getEmail());
		employerBusinessRules.checkWebSite(addEmployerRequest.getWebSite());
		employerBusinessRules.checkWebSiteDomain(addEmployerRequest.getWebSite(), addEmployerRequest.getEmail());
		employerBusinessRules.checkPasswordFields(addEmployerRequest.getPassword(), addEmployerRequest.getConfirmPassword());
		
		
		Employer employer = new Employer();
		employer = modelMapperService.forRequest().map(addEmployerRequest, Employer.class);
		
		emailVerificationService.sendEmail(addEmployerRequest.getEmail());
		
		employerRepository.save(employer);
		
		
	}


	@Override
	public GetEmployerResponse getEmployerByEmail(String email) {
		
		Employer target = employerRepository.getByEmail(email);
		
		if(target != null) {
			GetEmployerResponse employerResponse = modelMapperService.forResponse().map(target, GetEmployerResponse.class);
			return employerResponse;
		}
		return null;
	}


	@Override
	public boolean exitsByEmail(String email) {
		
		return employerRepository.existsByEmail(email);
	}


	@Override
	public GetEmployerResponse getEmployerById(int id) {
		
		Employer target = employerRepository.findById(id).orElse(null);
		
		if(target != null) {
			GetEmployerResponse employerResponse = modelMapperService.forResponse().map(target, GetEmployerResponse.class);
			return employerResponse;
		}
		
		return null;
	}

}
