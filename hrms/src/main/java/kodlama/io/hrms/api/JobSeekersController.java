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
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.requests.jobSeekerRequests.AddJobSeekerRequest;
import kodlama.io.hrms.business.responses.jobSeekerResponses.GetAllJobSeekerResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/jobseekers")
@AllArgsConstructor
public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;
	
	@GetMapping
	public List<GetAllJobSeekerResponse> getAll(){
		
		return jobSeekerService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid() AddJobSeekerRequest addJobSeekerRequest) {
		
		jobSeekerService.add(addJobSeekerRequest);
	}

}
