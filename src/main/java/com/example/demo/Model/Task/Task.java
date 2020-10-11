package com.example.demo.Model.Task;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity(name = "fix_list")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task")
    private String task;
    @Column(name = "login")
    private String login;
    @Enumerated(value = EnumType.STRING)
    private State state;
}
