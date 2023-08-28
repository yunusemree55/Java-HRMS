package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.business.requests.cv.jobExperienceRequests.AddJobExperienceRequest;
import kodlama.io.hrms.business.responses.cv.jobExperienceResponses.GetAllJobExperienceResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/jobexperiences")
@AllArgsConstructor
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;
	
	@GetMapping
	List<GetAllJobExperienceResponse> getAll(){
		
		return jobExperienceService.getAll();
		
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	void add(@RequestBody AddJobExperienceRequest addJobExperienceRequest) {
		
		jobExperienceService.add(addJobExperienceRequest);
	}

}
