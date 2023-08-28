package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import kodlama.io.hrms.entities.abstracts.User;
import kodlama.io.hrms.entities.concretes.cvs.Cv;
import kodlama.io.hrms.entities.concretes.cvs.Photo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity 
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobSeekers")
public class JobSeeker extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name = "firstName")
	private String firstName; 
	   
	@Column(name = "lastName") 
	private String lastName;
	
	@Column(name = "identityNumber")
	private String identityNumber; 
	
	@Column(name = "dateOfBirth") 
	private LocalDate dateOfBirth;
	
	
	@OneToOne(mappedBy = "jobSeeker")
	private Cv cv;
	
	@OneToOne(mappedBy = "jobSeeker")
	private Photo photo;
	
	
} 
