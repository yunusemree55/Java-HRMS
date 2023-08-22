package kodlama.io.hrms.business.requests.jobSeekerRequests;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddJobSeekerRequest {
	
	@Size(min = 3,message = "İsim alanı en az 3 karakter içermelidir")
	private String firstName;
	
	@Size(min = 3,message = "Soyisim alanı en az 3 karakter içermelidir")
	private String lastName;
	
	@NotNull(message = "Email alanı boş bırakılamaz")
	@NotBlank
	private String email;
	
	@NotNull(message = "TC Kimlik alanı boş bırakılamaz")
	@NotBlank
	@Size(max = 11,min = 11,message = "TC Kimlik 11 haneli olmalı")
	private String identityNumber;
	
	
	private LocalDate dateOfBirth;
	
	@Size(min = 3,message = "Şifre alanı en az 3 karakter olmalıdır")
	private String password;
	
	@Size(min = 3,message = "Şifre doğrulama alanı en az 3 karakter olmalıdır")
	private String confirmPassword;

}
