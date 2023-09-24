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
import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.business.requests.jobExperienceRequests.AddJobExperienceRequest;
import kodlama.io.hrms.business.responses.jobExperienceResponses.GetAllJobExperienceResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/jobexperiences")
@AllArgsConstructor
@CrossOrigin
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;
	
	@GetMapping("/getall")
	List<GetAllJobExperienceResponse> getAll(){
		
		return jobExperienceService.getAll();
		
	}
	
	@GetMapping("/getjobexperiencesbyjobseekerid/{id}")
	public List<GetAllJobExperienceResponse> getJobExperiencesByJobSeekerId(@PathVariable int id){
		return jobExperienceService.getJobExperiencesByJobSeekerId(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	void add(@RequestBody @Valid AddJobExperienceRequest addJobExperienceRequest) {
		
		jobExperienceService.add(addJobExperienceRequest);
	}

}
