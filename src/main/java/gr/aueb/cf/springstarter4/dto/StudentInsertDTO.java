package gr.aueb.cf.springstarter4.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StudentInsertDTO {

    @Email
    private String email;

//    @NotBlank
//    @Size(min = 3, max = 50)
    private String firstname;

//    @NotBlank
//    @Size(min = 3, max = 50)
    private String lastname;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
