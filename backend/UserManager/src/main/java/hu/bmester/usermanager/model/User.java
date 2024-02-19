package hu.bmester.usermanager.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birth_name")
    private String birthName;

    @Column(name = "mothers_name")
    private String mothersName;

    @ManyToOne
    @JoinColumn(name = "gender")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "nationality")
    private Nationality nationality;

    @Column(name = "phone")
    private String phone;

    @Column(name = "tax_number")
    private String taxNumber;

}
