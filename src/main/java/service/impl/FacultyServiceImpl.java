package service.impl;

import domain.Department;
import domain.Faculty;
import repository.Repository;
import repository.impl.DepartmentRepository;
import repository.impl.FacultyRepository;
import service.FacultyService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FacultyServiceImpl implements FacultyService {
    private final Repository<Faculty> facultyRepository;
    private final Repository<Department> departmentRepository;

    public FacultyServiceImpl() {
        facultyRepository = new FacultyRepository();
        departmentRepository = new DepartmentRepository();
    }

    @Override
    public Faculty saveOrUpdateFaculty(Faculty faculty) {
        List<Department> departments = departmentRepository.getAll();
        Set<Department> departmentSet = departments.stream().collect(Collectors.toSet());
        faculty.setDepartmentSet(departmentSet);
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
