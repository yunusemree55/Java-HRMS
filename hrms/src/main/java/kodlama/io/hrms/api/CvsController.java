package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.requests.cvRequests.AddCvRequest;
import kodlama.io.hrms.business.requests.cvRequests.UpdateCvRequest;
import kodlama.io.hrms.business.responses.cvResponses.GetAllCvWithJobSeekerResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cvs")
@AllArgsConstructor
@CrossOrigin
public class CvsController {
	
	private CvService cvService;
	
	@GetMapping("/getall")
	List<GetAllCvWithJobSeekerResponse> getAll(){
		
		return cvService.getAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	void add(@RequestBody AddCvRequest addCvRequest) {
	
		cvService.add(addCvRequest);
	}
	
	@PutMapping("/update")
	void update(@RequestBody UpdateCvRequest updateCvRequest) {
		
		cvService.update(updateCvRequest);
	}
	

}
