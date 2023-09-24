package kodlama.io.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.business.requests.jobAdvertisementRequests.AddJobAdvertisementRequest;
import kodlama.io.hrms.business.requests.jobAdvertisementRequests.UpdateJobAdvertisementRequest;
import kodlama.io.hrms.business.responses.jobAdvertisementResponses.GetAllJobAdvertisementResponse;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementRepository;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementRepository jobAdvertisementRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllJobAdvertisementResponse> getAll() {
		
		List<GetAllJobAdvertisementResponse> jobAdvertisementResponseList = jobAdvertisementRepository
				.findAll().stream().map(jobAdvertisement -> modelMapperService.forResponse()
				.map(jobAdvertisement, GetAllJobAdvertisementResponse.class))
				.collect(Collectors.toList());
		
		return jobAdvertisementResponseList;
		
		
	}
	
	
	@Override
	public List<GetAllJobAdvertisementResponse> getActiveJobAdvertisements() {
		
		List<GetAllJobAdvertisementResponse> activeJobAdvertisementResponseList = 
				jobAdvertisementRepository.getActiveJobAdvertisements().stream()
				.map(activeJobAdvertisement -> modelMapperService.forResponse()
						.map(activeJobAdvertisement, GetAllJobAdvertisementResponse.class))
				.collect(Collectors.toList());
		
		return activeJobAdvertisementResponseList;
		
	}
	
	@Override
	public List<GetAllJobAdvertisementResponse> getJobAdvertisementByCompanyName(String companyName) {
		
		
		List<GetAllJobAdvertisementResponse> jobAdvertisementResponseList = jobAdvertisementRepository.getJobAdvertisementByCompanyName(companyName).stream()
				.map(jobAdvertisement -> modelMapperService.forResponse().map(jobAdvertisement, GetAllJobAdvertisementResponse.class))
				.collect(Collectors.toList());
		
		return jobAdvertisementResponseList;
		
	}
	
	
	@Override
	public List<GetAllJobAdvertisementResponse> getJobAdvertisementByEndingDate() {
		List<GetAllJobAdvertisementResponse> jobAdvertisementResponseList = jobAdvertisementRepository.getJobAdvertisementByEndingDate()
				.stream().map(jobAdvertisement -> modelMapperService.forResponse().map(jobAdvertisement, GetAllJobAdvertisementResponse.class))
				.collect(Collectors.toList());
		
		return jobAdvertisementResponseList;
	}
	
	@Override
	public List<GetAllJobAdvertisementResponse> getJobAdvertisementsByEmployerId(int id) {
		
		List<GetAllJobAdvertisementResponse> jobAdvertisementResponses = jobAdvertisementRepository.getJobAdvertisementsByEmployerId(id)
				.stream().map(jobAdvertisement -> modelMapperService.forResponse().map(jobAdvertisement, GetAllJobAdvertisementResponse.class))
				.collect(Collectors.toList());
		
		return jobAdvertisementResponses;
	}
	
	@Override
	public GetAllJobAdvertisementResponse getJobAdvertisementById(int id) {
		
		JobAdvertisement target = jobAdvertisementRepository.findById(id).orElseThrow();
		GetAllJobAdvertisementResponse jobAdvertisementResponse = modelMapperService.forResponse().map(target, GetAllJobAdvertisementResponse.class);
		
		return jobAdvertisementResponse;
	}
	
	

	@Override
	public void add(AddJobAdvertisementRequest addJobAdvertisementRequest) {
		JobAdvertisement jobAdvertisement = modelMapperService.forRequest()
				.map(addJobAdvertisementRequest, JobAdvertisement.class);
		
		jobAdvertisement.setStartingDate(LocalDate.now());
		
		jobAdvertisementRepository.save(jobAdvertisement);
		
	}

	@Override
	public void delete(int id) {
		
		jobAdvertisementRepository.deleteById(id);
		
	}


	@Override
	public void update(UpdateJobAdvertisementRequest jobAdvertisementRequest) {
		
		JobAdvertisement target = jobAdvertisementRepository.findById(jobAdvertisementRequest.getId()).orElseThrow();
		
		JobAdvertisement jobAdvertisement = modelMapperService.forRequest().map(jobAdvertisementRequest, JobAdvertisement.class);
		
		jobAdvertisement.setStartingDate(target.getStartingDate());
		
		jobAdvertisementRepository.save(jobAdvertisement);
		 
		
	}


	@Override
	public List<GetAllJobAdvertisementResponse> getJobAdvertisementsByJobPositionId(int id) {
		
		List<GetAllJobAdvertisementResponse> jobAdvertisementResponseList = jobAdvertisementRepository.getJobAdvertisementsByJobPositionId(id).stream()
				.map(jobAdvertisement -> modelMapperService.forResponse().map(jobAdvertisement, GetAllJobAdvertisementResponse.class))
				.collect(Collectors.toList());
		
		return jobAdvertisementResponseList;
	}


	


	


	

	
	
	
}
