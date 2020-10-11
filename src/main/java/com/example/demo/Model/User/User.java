package com.example.demo.Model.User;


import com.example.demo.Form.UserForm;
import com.example.demo.Model.Task.Task;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@Entity(name = "fix_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "login")
    private String login;
    @Column()
    private String hashPass;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @OneToMany
    private List<Task> taskList;

    public static User from(UserForm form) {
        return User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .login(form.getLogin())
                .build();
    }
}
