package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.employerRequests.AddEmployerRequest;
import kodlama.io.hrms.business.responses.employerResponses.GetAllEmployerResponse;

public interface EmployerService {
	
	List<GetAllEmployerResponse> getAll();
	void add(AddEmployerRequest addEmployerRequest);

}
