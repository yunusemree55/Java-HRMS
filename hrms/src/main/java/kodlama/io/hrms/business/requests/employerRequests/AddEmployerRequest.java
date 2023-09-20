package kodlama.io.hrms.business.requests.employerRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployerRequest {
	
	@Size(min = 3,message = "Şirket adı en az 3 karakter içermelidir")
	private String companyName;
	
	@NotNull(message = "Email alanı boş bırakılamaz")
	@NotBlank
	private String email;
	
	@NotNull
	@NotBlank(message = "Web site alanı boş bırakılamaz")
	private String webSite;
	
	@NotNull(message = "Telefon numarası alanı boş bırakılamaz")
	@NotBlank
	@Size(max = 12,min = 12,message = "Telefon alanı 12 haneli olmalıdır")
	private String phoneNumber;
	
	@Size(min = 3,message = "Şifre alanı en az 3 karakter olmalıdır")
	private String password;
	
	@Size(min = 3,message = "Şifre doğrulama alanı en az 3 karakter olmalıdır")
	private String confirmPassword;

}
