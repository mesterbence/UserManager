package hu.bmester.usermanager.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.bmester.usermanager.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AddressType type;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;
}
