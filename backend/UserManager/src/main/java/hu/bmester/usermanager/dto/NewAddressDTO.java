package hu.bmester.usermanager.dto;

import hu.bmester.usermanager.model.user.AddressType;
import hu.bmester.usermanager.model.user.User;
import lombok.Data;


@Data
public class NewAddressDTO {
    private AddressType type;
    private User user;
    private String postCode;
    private String city;
    private String street;
    private String number;
}
