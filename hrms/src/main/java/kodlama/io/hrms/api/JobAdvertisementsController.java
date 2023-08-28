package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.business.requests.jobAdvertisementRequests.AddJobAdvertisementRequest;
import kodlama.io.hrms.business.requests.jobAdvertisementRequests.UpdateJobAdvertisementRequest;
import kodlama.io.hrms.business.responses.jobAdvertisementResponses.GetAllJobAdvertisementResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/jobadvertisements")
@AllArgsConstructor
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@GetMapping("/getall")
	public List<GetAllJobAdvertisementResponse> getAll(){
		
		return jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getActiveJobAdvertisements")
	public List<GetAllJobAdvertisementResponse> getActiveJobAdvertisements(){
		
		return jobAdvertisementService.getActiveJobAdvertisements();
		
	}
	
	@GetMapping("/getJobAdvertisementByEndingDate")
	public List<GetAllJobAdvertisementResponse> getJobAdvertisementByEndingDate(){
		
		return jobAdvertisementService.getJobAdvertisementByEndingDate();
	}
	
	@GetMapping("/getJobAdvertisementByCompanyName/:companyName")
	public List<GetAllJobAdvertisementResponse> getJobAdvertisementByCompanyName(@RequestParam String companyName){
		
		return jobAdvertisementService.getJobAdvertisementByCompanyName(companyName);
	}
	
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid AddJobAdvertisementRequest addJobAdvertisementRequest) {
		
		jobAdvertisementService.add(addJobAdvertisementRequest);
	}
	
	@PutMapping
	public void update(UpdateJobAdvertisementRequest jobAdvertisementRequest) {
		
		jobAdvertisementService.update(jobAdvertisementRequest);
	}
	
	@DeleteMapping("/delete/:id")
	public void delete(@RequestParam int id) {
		
		jobAdvertisementService.delete(id);
	}
	
	

}
