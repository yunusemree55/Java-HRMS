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

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.business.requests.cityRequests.AddCityRequest;
import kodlama.io.hrms.business.responses.cityResponses.GetAllCityResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
@CrossOrigin
public class CitiesController {
	
	private CityService cityService;
	
	@GetMapping("/getall")
	public List<GetAllCityResponse> getAll(){
		
		return cityService.getAll();
	}
	
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody AddCityRequest addCityRequest) {
		
		cityService.add(addCityRequest);
		
	}

}
