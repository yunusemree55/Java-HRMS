package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.requests.employerRequests.AddEmployerRequest;
import kodlama.io.hrms.business.responses.employerResponses.GetAllEmployerResponse;
import kodlama.io.hrms.business.responses.employerResponses.GetEmployerResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employers")
@AllArgsConstructor
@CrossOrigin
public class EmployersController {
	
	private EmployerService employerService;
	
	@GetMapping("/getall")
	public List<GetAllEmployerResponse> getAll(){
		
		return employerService.getAll();
	}
	
	@GetMapping("/getemployerbyemail/:email") 
	public GetEmployerResponse getEmployerByEmail(String email){
		
		return employerService.getEmployerByEmail(email);
	}
	
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddEmployerRequest addEmployerRequest) {
		
		employerService.add(addEmployerRequest);
		
	}
	
	@GetMapping("/existsByEmail/:email")
	public boolean existsByEmail(String email) {
		
		return employerService.exitsByEmail(email);
	}
	
	@GetMapping("/getemployerbyid/{id}")
	public GetEmployerResponse getEmployerById(@PathVariable int id) {
		
		return employerService.getEmployerById(id);
	}

}
