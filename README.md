# Java-SpringBoot

## HRMS ERD Diagram


![hrms-erd](https://github.com/yunusemree55/Java-SpringBoot/assets/77694646/8490a9a6-852f-47a8-9fcf-5f6b10657ebb)


I use Spring boot and PostgreSQL in this project. There are 5 main layers which are **Entities,Data Access, Business, Api and Core**. I checked important values with business rules and Validation which is library of Spring boot. For example: 

* If email is existed before, new Job seekers or employers cannot add this email
* I checked email if it's suitable for regex.
* Employer's website domain needs to contain email. For example Company's email is `abc@gmail.com`, this company's website must be `https://www.abc.com`

and so on.

**Job seekers** can add their **cvs** and **photos**. Also **Employer** can add multiple **job advertisements** and photos. There are a lot of informations about job seekers.
> Job Seeker fields:
* First Name
* Last Name
* Date of Birth
* Identity Number
* Entrance Date
* Graduation Date
* University (FK)
* Department (FK)

Job Seekers can add their job experiences, languages and programming languages they know to their profile

Job advertisement fields: 
* Description
* Starting Date (Default value is NOW)
* Ending Date
* Min Salary
* Max Salary
* Number of Position
* City
* Job Position
* Status (Active or Passive)

and so on
