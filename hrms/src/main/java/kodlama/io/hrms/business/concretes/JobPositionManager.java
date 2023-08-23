package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.business.requests.jobPositionRequests.AddJobPositionRequest;
import kodlama.io.hrms.business.responses.jobPositionResponses.GetAllJobPositionResponse;
import kodlama.io.hrms.business.rules.JobPositionBusinessRules;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionRepository;
import kodlama.io.hrms.entities.concretes.JobPosition;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobPositionManager implements JobPositionService{

	private JobPositionRepository jobPositionRepository;
	private ModelMapperService modelMapperService;
	private JobPositionBusinessRules jobPositionBusinessRules;
	
	
	@Override
	public List<GetAllJobPositionResponse> getAll() {
		
		List<GetAllJobPositionResponse> jobPositionResponseList = jobPositionRepository.findAll()
				.stream().map(jobPosition -> modelMapperService.forResponse().map(jobPosition, GetAllJobPositionResponse.class))
				.collect(Collectors.toList());
		
		
		return jobPositionResponseList;
		
		
	}


	@Override
	public void add(AddJobPositionRequest addJobPositionRequest) {
		
		jobPositionBusinessRules.checkJobPositionIfExists(addJobPositionRequest.getName());
		
		JobPosition jobPosition = modelMapperService.forRequest().map(addJobPositionRequest, JobPosition.class);
		
		
		jobPositionRepository.save(jobPosition);
		 
		 
	}

}
