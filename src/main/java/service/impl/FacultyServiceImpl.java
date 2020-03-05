package service.impl;

import domain.Faculty;
import repository.Repository;
import repository.impl.FacultyRepository;
import service.FacultyService;

public class FacultyServiceImpl implements FacultyService {
    private final Repository<Faculty> facultyRepository;

    public FacultyServiceImpl() {
        facultyRepository = new FacultyRepository();
    }

    @Override
    public Faculty saveOrUpdateFaculty(Faculty faculty) {
        return facultyRepository.saveOrUpdate(faculty);
    }
}
