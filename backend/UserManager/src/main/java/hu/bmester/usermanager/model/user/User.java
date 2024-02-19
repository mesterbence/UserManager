package hu.bmester.usermanager.model.user;


import hu.bmester.usermanager.model.BaseEntity;
import hu.bmester.usermanager.model.user.Gender;
import hu.bmester.usermanager.model.user.Nationality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "birth_name", nullable = false)
    private String birthName;

    @Column(name = "mothers_name", nullable = false)
    private String mothersName;

    @ManyToOne
    @JoinColumn(name = "gender")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "nationality", nullable = false)
    private Nationality nationality;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "tax_number", nullable = false)
    private String taxNumber;

}
