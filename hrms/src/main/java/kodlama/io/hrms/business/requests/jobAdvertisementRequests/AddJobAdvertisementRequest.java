package kodlama.io.hrms.business.requests.jobAdvertisementRequests;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddJobAdvertisementRequest {
	
	@NotBlank(message = "Açıklama kısmı boş bırakılamaz")
	private String description;
	
	
	@NotNull(message = "Açık pozisyon sayısı alanı boş bırakılamaz")
	private int numberOfPosition;
	private String maxSalary;
	private String minSalary;
	private LocalDate endingDate;
	
	@NotNull(message = "İş Pozisyonu alanı boş bırakılamaz")
	private int jobPositionId;
	private int employerId;
	
	private int statusId;
	
	@NotNull(message = "Şehir alanı boş bırakılamaz")
	private int cityId;
	
	
	

}
