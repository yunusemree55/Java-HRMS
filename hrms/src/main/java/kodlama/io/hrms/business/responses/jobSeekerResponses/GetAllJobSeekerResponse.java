package kodlama.io.hrms.business.responses.jobSeekerResponses;

import java.time.LocalDate;

import kodlama.io.hrms.business.responses.cv.GetAllCvResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobSeekerResponse {
	
	private String firstName;
	private String lastName;
	private String email;
	private String identityNumber;
	private LocalDate dateOfBirth;
	private String photoUrl;
	private GetAllCvResponse cv;
	
	
}
