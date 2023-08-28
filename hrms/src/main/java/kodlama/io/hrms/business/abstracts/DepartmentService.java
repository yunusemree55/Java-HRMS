package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.business.requests.cv.departmentRequests.AddDepartmentRequest;
import kodlama.io.hrms.business.responses.cv.departmentResponses.GetAllDepartmentResponse;

public interface DepartmentService {
	
	List<GetAllDepartmentResponse> getAll();
	void add(AddDepartmentRequest addDepartmentRequest);

	
}
