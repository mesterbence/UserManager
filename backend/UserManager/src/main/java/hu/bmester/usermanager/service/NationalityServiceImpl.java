package hu.bmester.usermanager.service;

import hu.bmester.usermanager.model.Nationality;
import hu.bmester.usermanager.repository.NationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationalityServiceImpl implements NationalityService {

    @Autowired
    private NationalityRepository nationalityRepository;

    @Override
    public Nationality findNationalityById(Long id) {
        return nationalityRepository.findNationalityById(id);
    }
}
