package kodlama.io.hrms.entities.concretes.cvs;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cvs")
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cvId")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="universityId")
	private University university;
	
	@Column(name="entranceDate")
	private LocalDate entranceDate;
	
	@Column(name="graduationDate")
	private LocalDate graduationDate;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;
	
	@OneToMany(mappedBy = "cv")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "cv")
	private List<ProgrammingLanguage> programmingLanguages;
	
	@OneToMany(mappedBy = "cv")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "cv")
	private List<SocialMedia> socialMedias;
	
	
	@OneToOne
	@JoinColumn(name = "jobSeekerId")
	private JobSeeker jobSeeker;
	
	
	
}
