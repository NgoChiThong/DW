package com.project.register.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class Member {

    @NotEmpty(message = "Bạn không thể để trống dữ liệu này")
    @Email(message = "Email không hợp lệ. Thử lại.")
    private String email;

    @NotEmpty(message = "Bạn không thể để trống dữ liệu này")
    @Size(min = 8, message = "Mật khẩu có ít nhất 8 ký tự. Thử lại.")
    private String password;

    @NotEmpty(message = "Bạn không thể để trống dữ liệu này")
    private String name;

    private Date birthDate;

    private String gender;

    private String education;

    private String address;

    private String phone;

    // Default constructor
    public Member() {
    }

    // Parameterized constructor
    public Member(String email, String password, String name, Date birthDate, String gender, String education, String address, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.education = education;
        this.address = address;
        this.phone = phone;
    }

    // Getters and Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	public Object getConfirmPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}
