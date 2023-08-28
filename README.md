# Java-SpringBoot

## HRMS ERD Diagram

![hrms-erd-table](https://github.com/yunusemree55/Java-SpringBoot/assets/77694646/ebbe9ca0-c558-4650-89ca-f53a2383e518)

I use Spring boot and PostgreSQL in this project. There are 5 main layered which are **Entities,Data Access, Business, Api and Core**. I checked important values with business rules and Validation which is library of Spring boot. For example: 

* If email is existed before, new Job seekers or employers cannot add this email
* I checked email if it's suitable for regex.
* Employer's website domain needs to contain email. For example Company's email is `abc@gmail.com`, this company's website must be `https://www.abc.com`

and so on.

**Job seekers** can add their **cvs** and **photos**. Also **Employer** can add multiple **job advertisements**. There are a lot of information on Cv about job seekers.
> Cv:
* Description
* University
* Entrance Date (University)
* Graduation Date (University)
* Department
* Job Experiences
* Languages
* Programming Languages
* Social Medias

As you can see these fields are for Cv and let see job advertisement fields: 
* Description
* Starting Date (Default value is NOW)
* Ending Date
* Min Salary
* Max Salary
* Number of Position
* City
* Job Position
* Status (Active or Passive)

  
