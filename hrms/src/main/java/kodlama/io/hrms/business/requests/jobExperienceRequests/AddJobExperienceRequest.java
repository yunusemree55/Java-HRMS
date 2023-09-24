package kodlama.io.hrms.business.requests.jobExperienceRequests;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddJobExperienceRequest {
	
	@NotBlank(message = "Şirket adı boş bırakılamaz")
	private String companyName;
	
	@NotBlank(message = "Pozisyon alanı boş bırakılamaz")
	private String position;
	
	@NotNull(message = "Giriş tarihi boş bırakılamaz")
	private LocalDate entranceDate;

	private LocalDate leavingDate;
	private int jobSeekerId;

}
