package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.requests.jobSeekerRequests.AddJobSeekerRequest;
import kodlama.io.hrms.business.responses.jobSeekerResponses.GetAllJobSeekerResponse;
import kodlama.io.hrms.business.responses.jobSeekerResponses.GetJobSeekerResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/jobseekers")
@AllArgsConstructor
@CrossOrigin
public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;
	
	@GetMapping("/getall")
	public List<GetAllJobSeekerResponse> getAll(){
		
		return jobSeekerService.getAll();
	}
	
	@GetMapping("/getjobseekerbyemail/email={email}")
	public GetJobSeekerResponse getJobSeekerByEmailAndPassword(@RequestParam String email){
		
		return jobSeekerService.getJobSeekerByEmail(email);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid() AddJobSeekerRequest addJobSeekerRequest) {
		
		jobSeekerService.add(addJobSeekerRequest);
	}
	
	@GetMapping("/existsbyidentitynumber/:identityNumber")
	public boolean existsByIdentityNumber(@RequestParam String identityNumber) {
		
		return jobSeekerService.existsByIdentityNumber(identityNumber);
	}
	
	@GetMapping("/existsbyemail/:email")
	public boolean existsByEmail(@RequestParam String email) {
		
		return jobSeekerService.existsByEmail(email);
	}
	
	@GetMapping("/getjobseekerbyid/{id}")
	public GetJobSeekerResponse getJobSeekerById(@PathVariable int id) {
		
		return jobSeekerService.getJobSeekerById(id);
		
	}

}
