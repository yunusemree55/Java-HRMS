package kodlama.io.hrms.business.responses.cvResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCvWithJobSeekerResponse {
	
	private String firstName;
	private String lastName;
	private String description;
	

}
