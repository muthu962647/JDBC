package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String email;
    private String name;
    private String password;
    private int role;
    private boolean isEnabled;
    private int sendTo;
}
