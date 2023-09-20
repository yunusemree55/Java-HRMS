package kodlama.io.hrms.business.responses.jobSeekerResponses;

import java.time.LocalDate;
import java.util.List;

import kodlama.io.hrms.business.responses.cv.GetAllCvResponse;
import kodlama.io.hrms.business.responses.cv.socialMediaResponses.GetAllSocialMediaResponse;
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
	private String universityName;
	private String departmentName;
	private LocalDate dateOfBirth;
	private LocalDate entranceDate;
	private LocalDate graduationDate;
	private String photoUrl;
	private GetAllCvResponse cv;
	private List<GetAllSocialMediaResponse> socialMedias;
	
	
}
