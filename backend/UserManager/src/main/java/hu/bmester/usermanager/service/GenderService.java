package hu.bmester.usermanager.service;

import hu.bmester.usermanager.model.user.Gender;

import java.util.List;

public interface GenderService {
    Gender findGenderById(Long id);
    List<Gender> findAll();
}
