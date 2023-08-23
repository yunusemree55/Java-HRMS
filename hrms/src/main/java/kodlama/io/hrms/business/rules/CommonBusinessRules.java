package kodlama.io.hrms.business.rules;

public interface CommonBusinessRules {
	
	void checkPasswordFields(String password,String confirmPassword);
	void checkEmailIfExistsBefore(String email);
	void checkEmailField(String email);
}
