package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.DepartmentService;
import kodlama.io.hrms.business.requests.cv.departmentRequests.AddDepartmentRequest;
import kodlama.io.hrms.business.responses.cv.departmentResponses.GetAllDepartmentResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentsController {
	
	private DepartmentService departmentService;
	
	@GetMapping
	public List<GetAllDepartmentResponse> getAll(){
		
		return departmentService.getAll();
		
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddDepartmentRequest addDepartmentRequest) {
		
		departmentService.add(addDepartmentRequest);
	}

}
