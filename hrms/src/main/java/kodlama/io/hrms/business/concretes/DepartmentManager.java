package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.DepartmentService;
import kodlama.io.hrms.business.requests.cv.departmentRequests.AddDepartmentRequest;
import kodlama.io.hrms.business.responses.cv.departmentResponses.GetAllDepartmentResponse;
import kodlama.io.hrms.core.utilities.mapper.ModelMapperService;
import kodlama.io.hrms.dataAccess.abstracts.DepartmentRepository;
import kodlama.io.hrms.entities.concretes.Department;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentManager implements DepartmentService {
	
	private DepartmentRepository departmentRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllDepartmentResponse> getAll() {
		
		List<GetAllDepartmentResponse> departmentResponseList = departmentRepository.findAll().stream().map(department ->
		modelMapperService.forResponse().map(department, GetAllDepartmentResponse.class)).collect(Collectors.toList());
		
		return departmentResponseList;
	}
	@Override
	public void add(AddDepartmentRequest addDepartmentRequest) {
		
		Department department = modelMapperService.forRequest().map(addDepartmentRequest, Department.class);
		
		departmentRepository.save(department);
		
	}
	
	

}
