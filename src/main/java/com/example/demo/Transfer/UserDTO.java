package com.example.demo.Transfer;

import com.example.demo.Model.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;

    public static UserDTO from(User user) {
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

}
