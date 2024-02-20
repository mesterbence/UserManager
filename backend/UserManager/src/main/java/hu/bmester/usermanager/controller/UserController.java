package hu.bmester.usermanager.controller;

import hu.bmester.usermanager.dto.NewUserDTO;
import hu.bmester.usermanager.model.user.Address;
import hu.bmester.usermanager.model.user.AddressType;
import hu.bmester.usermanager.model.user.User;
import hu.bmester.usermanager.service.AddressService;
import hu.bmester.usermanager.service.GenderService;
import hu.bmester.usermanager.service.NationalityService;
import hu.bmester.usermanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GenderService genderService;

    @Autowired
    private NationalityService nationalityService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/all")
    private ResponseEntity getAllUsers() {
        return new ResponseEntity(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity createNewUser(@Valid @RequestBody NewUserDTO newUserDTO) {
        if(newUserDTO.getAddresses() == null || newUserDTO.getAddresses().stream()
                .filter(address -> address.getType() == AddressType.PERMANENT)
                .collect(Collectors.toList()).isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        User toSave = User.builder()
                .lastName(newUserDTO.getLastName())
                .firstName(newUserDTO.getFirstName())
                .birthName(newUserDTO.getBirthName())
                .mothersName(newUserDTO.getMothersName())
                .gender(genderService.findGenderById(newUserDTO.getGenderId()))
                .nationality(nationalityService.findNationalityById(newUserDTO.getNationalityId()))
                .phone(newUserDTO.getPhone())
                .taxNumber(newUserDTO.getTaxNumber())
                .build();
        User savedUser = userService.saveUser(toSave);
        newUserDTO.getAddresses().forEach(address -> {
            Address newAddress = Address.builder()
                    .type(address.getType())
                    .postCode(address.getPostCode())
                    .city(address.getCity())
                    .street(address.getStreet())
                    .number(address.getNumber())
                    .user(savedUser)
                    .build();
            addressService.save(newAddress);
        });
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
