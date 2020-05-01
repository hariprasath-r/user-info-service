package in.hp.boot.userinfoservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

@ApiModel("User Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @JsonIgnore
    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty(name = "User First Name", required = true, position = 0)
    @NotEmpty
    @Size(min = 4, message = "Firstname should be not null and atleast 4 characters.")
    @Column(name = "first_name")
    private String fname;

    @ApiModelProperty(name = "User Last Name", required = true, position = 1)
    @NotEmpty
    @Size(min = 2, message = "Lastname should be not null and atleast 2 characters.")
    @Column(name = "last_name")
    private String lname;

    @ApiModelProperty(name = "User Email ID", required = true, position = 2, example = "abc@xyz.com")
    @Email(message = "Email address invalid")
    @NotEmpty
    @Column(unique = true)
    private String email;

    @ApiModelProperty(name = "User Date Of Birth", required = true, position = 3, example = "1995-08-24")
    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_birth;
}
