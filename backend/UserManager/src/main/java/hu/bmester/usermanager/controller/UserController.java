package hu.bmester.usermanager.controller;

import hu.bmester.usermanager.dto.NewUserDTO;
import hu.bmester.usermanager.model.User;
import hu.bmester.usermanager.service.GenderService;
import hu.bmester.usermanager.service.NationalityService;
import hu.bmester.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GenderService genderService;

    @Autowired
    private NationalityService nationalityService;

    @GetMapping("/all")
    private ResponseEntity getAllUsers() {
        return new ResponseEntity(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity createNewUser(@RequestBody NewUserDTO newUserDTO) {
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
        userService.saveUser(toSave);
        return new ResponseEntity(toSave, HttpStatus.CREATED);
    }
}
