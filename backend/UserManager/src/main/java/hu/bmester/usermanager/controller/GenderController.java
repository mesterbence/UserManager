package hu.bmester.usermanager.controller;

import hu.bmester.usermanager.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gender")
@CrossOrigin("*")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping("/all")
    private ResponseEntity getAllGenders() {
        return new ResponseEntity(genderService.findAll(), HttpStatus.OK);
    }
}
