package hu.bmester.usermanager.service;

import hu.bmester.usermanager.model.user.Nationality;

import java.util.List;

public interface NationalityService {
    Nationality findNationalityById(Long id);
    List<Nationality> findAll();
}
