package hu.bmester.usermanager.service;

import hu.bmester.usermanager.model.user.Gender;
import hu.bmester.usermanager.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Override
    public Gender findGenderById(Long id) {
        return genderRepository.findGenderById(id);
    }
}
