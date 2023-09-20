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

import kodlama.io.hrms.business.abstracts.UniversityService;
import kodlama.io.hrms.business.requests.cv.universityRequests.AddUniversityRequest;
import kodlama.io.hrms.business.responses.cv.universityResponses.GetAllUniversityResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/universities")
@AllArgsConstructor
@CrossOrigin
public class UniversitiesController {
	
	private UniversityService universityService;
	
	@GetMapping("/getall")
	public List<GetAllUniversityResponse> getAll(){
		
		return universityService.getAll();
		
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddUniversityRequest addUniversityRequest) {
		
		universityService.add(addUniversityRequest);
	}
	

}
