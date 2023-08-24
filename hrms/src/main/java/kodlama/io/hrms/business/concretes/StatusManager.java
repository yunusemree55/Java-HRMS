package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import kodlama.io.hrms.business.abstracts.StatusService;
import kodlama.io.hrms.business.requests.statusRequests.AddStatusRequest;
import kodlama.io.hrms.business.responses.statusResponses.GetAllStatusResponse;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.StatusRepository;
import kodlama.io.hrms.entities.concretes.Status;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatusManager implements StatusService{
	
	private StatusRepository statusRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllStatusResponse> getAll() {
		
		List<GetAllStatusResponse> statusResponseList = statusRepository.findAll()
				.stream().map(status -> modelMapperService.forResponse()
						.map(status, GetAllStatusResponse.class)).collect(Collectors.toList());
			
		
		return statusResponseList;
		
	}
	@Override
	public void add(AddStatusRequest addStatusRequest) {
		
		Status status = modelMapperService.forRequest().map(addStatusRequest, Status.class);
		
		
		statusRepository.save(status);
		
		
		
	}

}
