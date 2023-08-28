package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.requests.employerRequests.AddEmployerRequest;
import kodlama.io.hrms.business.responses.employerResponses.GetAllEmployerResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employers")
@AllArgsConstructor
public class EmployersController {
	
	private EmployerService employerService;
	
	@GetMapping("/getall")
	public List<GetAllEmployerResponse> getAll(){
		
		return employerService.getAll();
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddEmployerRequest addEmployerRequest) {
		
		employerService.add(addEmployerRequest);
		
	}

}
