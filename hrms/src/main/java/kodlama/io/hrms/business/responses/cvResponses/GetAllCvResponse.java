package kodlama.io.hrms.business.responses.cvResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCvResponse {
	
	private int id;
	private int jobSeekerId;
	private String description;
	

}
