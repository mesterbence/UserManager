package hu.bmester.usermanager.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewUserDTO {

    private String lastName;
    private String firstName;
    private String birthName;
    private String mothersName;
    private Long genderId;
    private Long nationalityId;
    private String phone;
    private String taxNumber;
    List<NewAddressDTO> addresses;

}
