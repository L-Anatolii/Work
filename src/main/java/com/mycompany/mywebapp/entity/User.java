package com.mycompany.mywebapp.entity;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 45)
    private String password;

    @Column(nullable = false, length = 45, name = "first_name")
    private String firstName;

    @Column(nullable = false, length = 45, name = "last_name")
    private String lastName;

    @Column(nullable = false, length = 256, name = "file_name")
    private String fileName;

    private boolean enabled;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "\nid=" + id +
                ", \nemail='" + email + '\'' +
                ", \npassword='" + password + '\'' +
                ", \nfirstName='" + firstName + '\'' +
                ", \nlastName='" + lastName + '\'' +
                ", \nfileName='" + fileName + '\'' +
                ", \nenabled=" + enabled +
                '}';
    }
}
