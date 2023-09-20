package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.employerRequests.AddEmployerRequest;
import kodlama.io.hrms.business.responses.employerResponses.GetAllEmployerResponse;
import kodlama.io.hrms.business.responses.employerResponses.GetEmployerResponse;

public interface EmployerService {
	
	List<GetAllEmployerResponse> getAll();
	GetEmployerResponse getEmployerByEmail(String email);
	GetEmployerResponse getEmployerById(int id);
	boolean exitsByEmail(String email);
	void add(AddEmployerRequest addEmployerRequest);
	

}
