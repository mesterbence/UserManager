package hu.bmester.usermanager.service;

import hu.bmester.usermanager.model.user.Gender;

public interface GenderService {
    Gender findGenderById(Long id);
}
