package kodlama.io.hrms;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import kodlama.io.hrms.core.exceptions.BusinessException;
import kodlama.io.hrms.core.exceptions.ProblemDetail;
import kodlama.io.hrms.core.exceptions.ValidationProblemDetail;
import kodlama.io.hrms.core.utilities.verifications.EmailVerificationManager;

@SpringBootApplication
@RestControllerAdvice
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail handleBusinessException(BusinessException businessException) {
		ProblemDetail problemDetail = new ProblemDetail();
		
		problemDetail.setMessage(businessException.getMessage());

		return problemDetail;
	}
	
	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ProblemDetail handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		
		ValidationProblemDetail validationProblemDetail = new ValidationProblemDetail();
		validationProblemDetail.setProblems(new HashMap<String, String>());
		validationProblemDetail.setMessage("Validasyon Hatası meydana geldi");
		
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			
			validationProblemDetail.getProblems().put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		
		return validationProblemDetail;
		
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail handleMaxUploadSizeExceededException(MaxUploadSizeExceededException maxUploadSizeExceededException) {
		
		ProblemDetail problemDetail = new ProblemDetail("Yüklemeye çalıştığınız fotoğraf boyutu çok büyük");
		
		return problemDetail;
		
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail handleDataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
		
		ProblemDetail problemDetail = new ProblemDetail("Böyle bir dataya ait veri zaten mevcut");
		
		return problemDetail;
	}
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public EmailVerificationManager emailVerification() {
		return new EmailVerificationManager();
	}
	
	
	
	 
}
   