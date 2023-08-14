package com.example.assignment13.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class UserModel {

    @NotNull(message = "ID must not be empty")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 4,message = "Name length must be more than 4")
    @Column(columnDefinition = "varchar(10) not null CHECK(LENGTH(name)>=4)")
    private String name;

    @NotEmpty(message = "Username must not be empty")
    @Size(min = 4,message = "Username length must be more than 4")
    @Column(columnDefinition = "varchar(10) unique not null CHECK(LENGTH(name)>=4)")
    private String username;

    @NotEmpty(message = "Password must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be a valid format")
    @Column(columnDefinition = "varchar(30) unique not null CHECK(email REGEXP '([a-zA-Z0-9]{6,})(@)([a-zA-Z]{6,})(\\.)([a-zA-Z]{2,})')")
    private String email;

    @NotEmpty(message = "Role must not be empty")
    @Pattern(regexp = "user|admin",message = "Role must be user or admin")
    @Column(columnDefinition = "varchar(5) not null CHECK(role='user' or role='admin')")
    private String role;

    @NotNull(message = "Age must not be empty")
    @Positive(message = "Age must be a number")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
