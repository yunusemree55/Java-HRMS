package kodlama.io.hrms.business.responses.jobSeekerResponses;

import java.time.LocalDate;
import java.util.List;

import kodlama.io.hrms.business.responses.cvResponses.GetAllCvResponse;
import kodlama.io.hrms.business.responses.jobExperienceResponses.GetAllJobExperienceResponse;
import kodlama.io.hrms.business.responses.languageResponses.GetAllLanguageResponse;
import kodlama.io.hrms.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.hrms.business.responses.socialMediaResponses.GetAllSocialMediaResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetJobSeekerResponse {
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String identityNumber;
	private LocalDate dateOfBirth;
	private String photoUrl;
	private String universityName;
	private LocalDate entranceDate;
	private LocalDate graduationDate;
	private String departmentName;
	private List<GetAllSocialMediaResponse> socialMedias;
	private List<GetAllLanguageResponse> languages;
	private List<GetAllProgrammingLanguageResponse> programmingLanguages;
	private List<GetAllJobExperienceResponse> jobExperiences;
	private GetAllCvResponse cv;

}
