package kodlama.io.hrms.core.utilities.mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	
	ModelMapper forRequest();
	ModelMapper forResponse();

}
