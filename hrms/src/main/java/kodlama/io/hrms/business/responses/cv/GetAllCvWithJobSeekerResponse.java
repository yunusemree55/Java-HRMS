package kodlama.io.hrms.business.responses.cv;

import java.time.LocalDate;
import java.util.List;

import kodlama.io.hrms.business.responses.cv.ProgrammingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.hrms.business.responses.cv.jobExperienceResponses.GetAllJobExperienceResponse;
import kodlama.io.hrms.business.responses.cv.languageResponses.GetAllLanguageResponse;
import kodlama.io.hrms.business.responses.cv.socialMediaResponses.GetAllSocialMediaResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCvWithJobSeekerResponse {
	
	private String jobSeekerFirstName;
	private String jobSeekerLastName;
	private String description;
	private String universityName;
	private LocalDate entranceDate;
	private LocalDate graduationDate;
	private String departmentName;
	private List<GetAllProgrammingLanguageResponse> programmingLanguages;
	private List<GetAllJobExperienceResponse> jobExperiences;
	private List<GetAllLanguageResponse> languages;
	private List<GetAllSocialMediaResponse> socialMedias;

}
