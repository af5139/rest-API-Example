package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("UserInfo")
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2,message = "Name은 2글자 이상 입력해 주세요.")
    private String name;
    @Past
    private Date joinDate;

    //@JsonIgnore
    private String password;
    //@JsonIgnore
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(int id, String kenneth, Date date, String pass1, String s) {
    }
}
