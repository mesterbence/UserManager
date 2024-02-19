package hu.bmester.usermanager.service;

import hu.bmester.usermanager.model.user.Nationality;

public interface NationalityService {
    Nationality findNationalityById(Long id);
}
