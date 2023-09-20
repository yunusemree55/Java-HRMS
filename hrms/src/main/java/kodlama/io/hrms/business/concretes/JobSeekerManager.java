package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.requests.jobSeekerRequests.AddJobSeekerRequest;
import kodlama.io.hrms.business.responses.jobSeekerResponses.GetAllJobSeekerResponse;
import kodlama.io.hrms.business.responses.jobSeekerResponses.GetJobSeekerResponse;
import kodlama.io.hrms.business.rules.JobSeekerBusinessRules;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerRepository;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerRepository jobSeekerRepository;
	private ModelMapperService modelMapperService;
	private JobSeekerBusinessRules jobSeekerBusinessRules;
	
	@Override
	public List<GetAllJobSeekerResponse> getAll() {
		
		List<GetAllJobSeekerResponse> jobSeekerResponseList = jobSeekerRepository.findAll()
				.stream().map(jobSeeker ->  modelMapperService.forResponse()
				.map(jobSeeker, GetAllJobSeekerResponse.class))
				.collect(Collectors.toList());
		
		return jobSeekerResponseList;
	}

	@Override
	public void add(AddJobSeekerRequest addJobSeekerRequest) {
		
		
		jobSeekerBusinessRules.checkPasswordFields(addJobSeekerRequest.getPassword(),addJobSeekerRequest.getConfirmPassword());
		jobSeekerBusinessRules.checkEmailField(addJobSeekerRequest.getEmail());
		jobSeekerBusinessRules.checkEmailIfExistsBefore(addJobSeekerRequest.getEmail());
		jobSeekerBusinessRules.checkIdentityNumberExistsBefore(addJobSeekerRequest.getIdentityNumber());
		
		JobSeeker jobSeeker = modelMapperService.forRequest()
				.map(addJobSeekerRequest, JobSeeker.class);
		
		
		jobSeekerRepository.save(jobSeeker);
		
		
	}

	@Override
	public GetJobSeekerResponse getJobSeekerByEmail(String email){
		
		JobSeeker target = jobSeekerRepository.getByEmail(email);
		
		if(target != null) {
			GetJobSeekerResponse jobSeekerResponse = modelMapperService.forResponse().map(target, GetJobSeekerResponse.class);
			return jobSeekerResponse;
		}
		
		
		return null;
		
	}

	@Override
	public boolean existsByIdentityNumber(String identityNumber) {
		
		return jobSeekerRepository.existsByIdentityNumber(identityNumber);
	}

	@Override
	public boolean existsByEmail(String email) {
		
		return jobSeekerRepository.existsByEmail(email);
	}

	@Override
	public GetJobSeekerResponse getJobSeekerById(int id) {
		JobSeeker target = jobSeekerRepository.getReferenceById(id);
		GetJobSeekerResponse jobSeekerResponse = modelMapperService.forResponse().map(target, GetJobSeekerResponse.class);
		return jobSeekerResponse;
	}
	
	
	

}
