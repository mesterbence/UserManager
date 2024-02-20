package hu.bmester.usermanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class NewUserDTO {

    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @NotBlank
    private String birthName;

    private String mothersName;

    private Long genderId;

    @NotNull
    private Long nationalityId;

    @NotBlank
    private String phone;

    @NotBlank
    private String taxNumber;

    @NotNull
    List<NewAddressDTO> addresses;

}
