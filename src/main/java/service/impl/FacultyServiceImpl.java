package service.impl;

import domain.Faculty;
import repository.Repository;
import repository.impl.FacultyRepository;
import service.FacultyService;

import java.util.List;

public class FacultyServiceImpl implements FacultyService {
    private final Repository<Faculty> facultyRepository;

    public FacultyServiceImpl() {
        facultyRepository = new FacultyRepository();
    }

    @Override
    public Faculty saveOrUpdateFaculty(Faculty faculty) {
        return facultyRepository.saveOrUpdate(faculty);
    }

    @Override
    public Faculty getFaculty() {
        List<Faculty> all = facultyRepository.getAll();
        if(all.size() == 0) return new Faculty();
        Faculty faculty = all.stream().findFirst().get();
        if(faculty == null) return null;
        return faculty;
    }
}
