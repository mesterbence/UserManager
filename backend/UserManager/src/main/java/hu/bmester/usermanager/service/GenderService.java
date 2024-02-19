package hu.bmester.usermanager.service;

import hu.bmester.usermanager.model.Gender;

public interface GenderService {
    Gender findGenderById(Long id);
}
