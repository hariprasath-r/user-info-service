package in.hp.boot.userinfoservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String fname;
    private String lname;
    private String email;
    @Column(name = "date_of_birth")
    private Date date_of_birth;
}
