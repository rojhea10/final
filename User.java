/**
 * 
 */
package application;

import java.time.LocalDate;

/**
 * @author Rojhe
Create table Employment_Application
(
Full_name varchar(25) not null,
Email varchar(25) not null,
Address varchar(50) not null,
Position varchar(25) not null,
Gender varchar(7) not null,
Salary double(6,2) not null,
Start_Date varchar(30) NOT NULL,
Phone int(15) not null,
Education varchar(50) not null,
Relative varchar(3) not null,
Authorized varchar(3) not null, 
Comments varchar(100),
primary key(Phone)
);
 */
public class User {
    
	private String fullname;
private String address;
private String email;
private String education;
private String position;
private double salary;
private LocalDate startDate;
private int phone;
private String gender;
private String authorized;
private String relatives;
private String comments;


public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAuthorized() {
		return authorized;
	}
	public void setAuthorized(String authorized) {
		this.authorized = authorized;
	}
	public String getRelatives() {
		return relatives;
	}
	public void setRelatives(String relatives) {
		this.relatives = relatives;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}



}
