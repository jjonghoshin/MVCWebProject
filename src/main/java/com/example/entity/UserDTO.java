package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private int num; // 1 2 3 4 -> PK
    private String username; // id -> PK(X)->unique
    private String password;
    private String name; // 사용자 이름

}
