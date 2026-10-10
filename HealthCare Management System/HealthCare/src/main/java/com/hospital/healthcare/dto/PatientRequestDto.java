package com.hospital.healthcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDto {

    @NotBlank(message = "Patient name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Date of birth is mandatory")
    private String dob;

    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @NotBlank(message = "Contact number is mandatory")
    @Size(min = 10, max = 15, message = "Contact number must be valid")
    private String contact;

    @NotBlank(message = "Address is mandatory")
    private String address;

   
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}