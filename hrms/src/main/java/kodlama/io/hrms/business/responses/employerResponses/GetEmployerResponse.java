package kodlama.io.hrms.business.responses.employerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployerResponse {
	
	private int id;
	private String companyName;
	private String email;
	private String password;
	private String webSite;
	private String phoneNumber;
	private String photoUrl;

}
