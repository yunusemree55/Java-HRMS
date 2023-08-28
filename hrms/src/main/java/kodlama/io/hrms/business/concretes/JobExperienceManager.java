package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.business.requests.cv.jobExperienceRequests.AddJobExperienceRequest;
import kodlama.io.hrms.business.responses.cv.jobExperienceResponses.GetAllJobExperienceResponse;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.JobExperienceRepository;
import kodlama.io.hrms.entities.concretes.cvs.JobExperience;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceRepository jobExperienceRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllJobExperienceResponse> getAll() {
		
		List<GetAllJobExperienceResponse> jobExperienceResponseList = jobExperienceRepository.findAll().stream().map(jobExperience ->
		modelMapperService.forResponse().map(jobExperience, GetAllJobExperienceResponse.class)).collect(Collectors.toList());
		
		return jobExperienceResponseList;
	}
	@Override
	public void add(AddJobExperienceRequest addJobExperienceRequest) {
		
		JobExperience jobExperience = modelMapperService.forRequest().map(addJobExperienceRequest, JobExperience.class);
		jobExperience.setId(0);
		
		jobExperienceRepository.save(jobExperience);
		
	}
}
