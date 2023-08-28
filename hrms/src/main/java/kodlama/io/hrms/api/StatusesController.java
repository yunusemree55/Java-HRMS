package kodlama.io.hrms.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.StatusService;
import kodlama.io.hrms.business.requests.statusRequests.AddStatusRequest;
import kodlama.io.hrms.business.responses.statusResponses.GetAllStatusResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/statuses")
@AllArgsConstructor
public class StatusesController {

	private StatusService statusService;
	
	
	@GetMapping
	public List<GetAllStatusResponse> getAll(){
		
		return statusService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody AddStatusRequest addStatusRequest) {
		
		statusService.add(addStatusRequest);
	}
	
}
