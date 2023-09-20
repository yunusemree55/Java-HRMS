package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.business.requests.jobPositionRequests.AddJobPositionRequest;
import kodlama.io.hrms.business.responses.jobPositionResponses.GetAllJobPositionResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/jobpositions")
@AllArgsConstructor
@CrossOrigin
public class JobPositionsController {

	private JobPositionService jobPositionService;
	
	
	@GetMapping("/getall")
	public List<GetAllJobPositionResponse> getAll(){
		
		return jobPositionService.getAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddJobPositionRequest addJobPositionRequest) {
		
		jobPositionService.add(addJobPositionRequest);
	}
	
}
