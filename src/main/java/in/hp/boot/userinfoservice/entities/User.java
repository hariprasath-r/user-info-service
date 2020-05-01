package in.hp.boot.userinfoservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String fname;

    @ApiModelProperty(name = "User Last Name", required = true, position = 1)
    private String lname;

    @ApiModelProperty(name = "User Email ID", required = true, position = 2, example = "abc@xyz.com")
    @Column(unique = true)
    private String email;

    @ApiModelProperty(name = "User Date Of Birth", required = true, position = 3, example = "1995-08-24")
    @Column(name = "date_of_birth")
    private Date date_of_birth;
}
