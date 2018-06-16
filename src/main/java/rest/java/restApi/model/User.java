package rest.java.restApi.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@TableGenerator(name="userIdGenerator", initialValue = 3)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
                    generator = "userIdGenerator")
    private Long id;
    @Size(min = 2, max = 20, message = "{user.name.info}")
    private String name;
    private String surname;
    @Min(value = 18, message = "for adults only")
    @Max(value = 99, message = "too old")
    private Integer age;

    public User() {

    }

    public User(Long id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }


}
