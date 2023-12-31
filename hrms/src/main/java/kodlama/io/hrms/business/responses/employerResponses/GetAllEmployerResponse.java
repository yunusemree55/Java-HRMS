package kodlama.io.hrms.business.responses.employerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployerResponse {

	private int id;
	
	private String companyName;
	
	private String email;
	
	private String webSite;
	
	private String phoneNumber;
	
	private String photoUrl;
	
	
	
}
