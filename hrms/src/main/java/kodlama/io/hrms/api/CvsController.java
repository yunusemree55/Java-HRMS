package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.business.requests.cv.AddCvRequest;
import kodlama.io.hrms.business.responses.cv.GetAllCvWithJobSeekerResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cvs")
@AllArgsConstructor
public class CvsController {
	
	private CvService cvService;
	
	@GetMapping
	List<GetAllCvWithJobSeekerResponse> getAll(){
		
		return cvService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	void add(@RequestBody AddCvRequest addCvRequest) {
	
		cvService.add(addCvRequest);
	}
	

}