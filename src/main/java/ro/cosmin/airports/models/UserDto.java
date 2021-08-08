package ro.cosmin.airports.models;

import ro.cosmin.airports.enums.UserRole;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto {
    @NotEmpty
    @Email
    @Size(min = 6, max = 100)
    private String email;
    @NotEmpty
    @Size(min = 6, max = 40)
    private String password;
    @NotEmpty
    @Size(min = 1, max = 60)
    private String firstName;
    @NotEmpty
    @Size(min = 1, max = 60)
    private String lastName;
    private UserRole userRole;

    public UserDto() {
    }

    public UserDto(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDto(String email, String password, String firstName, String lastName, UserRole userRole) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
