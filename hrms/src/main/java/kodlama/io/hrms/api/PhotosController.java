package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.PhotoService;
import kodlama.io.hrms.business.requests.photoRequests.AddPhotoRequest;
import kodlama.io.hrms.business.responses.photoResponses.GetAllPhotoResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/photos")
@AllArgsConstructor
public class PhotosController {

	private PhotoService photoService;
	
	
	@GetMapping("/getall")
	public List<GetAllPhotoResponse> getAll(){
		
		return photoService.getAll();
		
	}
	
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@ModelAttribute AddPhotoRequest addPhotoRequest) {
		
		photoService.add(addPhotoRequest);
	}
	
}
 