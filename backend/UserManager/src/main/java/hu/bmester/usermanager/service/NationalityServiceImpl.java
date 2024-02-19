package hu.bmester.usermanager.service;

import hu.bmester.usermanager.model.user.Nationality;
import hu.bmester.usermanager.repository.NationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalityServiceImpl implements NationalityService {

    @Autowired
    private NationalityRepository nationalityRepository;

    @Override
    public Nationality findNationalityById(Long id) {
        return nationalityRepository.findNationalityById(id);
    }

    @Override
    public List<Nationality> findAll() {
        return nationalityRepository.findAll();
    }
}
