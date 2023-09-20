package kodlama.io.hrms.business.responses.cv;

import java.util.List;

import kodlama.io.hrms.business.responses.cv.ProgrammingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.hrms.business.responses.cv.jobExperienceResponses.GetAllJobExperienceResponse;
import kodlama.io.hrms.business.responses.cv.languageResponses.GetAllLanguageResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCvResponse {
	
	private String description;
	private List<GetAllProgrammingLanguageResponse> programmingLanguages;
	private List<GetAllJobExperienceResponse> jobExperiences;
	private List<GetAllLanguageResponse> languages;
	
}
