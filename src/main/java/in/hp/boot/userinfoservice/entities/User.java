package in.hp.boot.userinfoservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String date_of_birth;
}
