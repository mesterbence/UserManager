package hu.bmester.usermanager.controller;

import hu.bmester.usermanager.service.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nationality")
@CrossOrigin("*")
public class NationalityController {

    @Autowired
    private NationalityService nationalityService;

    @GetMapping("/all")
    private ResponseEntity getAllNationalities() {
        return new ResponseEntity(nationalityService.findAll(), HttpStatus.OK);
    }
}
