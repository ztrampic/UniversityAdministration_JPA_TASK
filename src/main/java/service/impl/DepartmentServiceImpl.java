package service.impl;

import domain.Department;
import domain.Faculty;
import enums.Messages;
import repository.Repository;
import repository.impl.DepartmentRepository;
import repository.impl.FacultyRepository;
import service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private final Repository<Department> departmentRepository;
    private final Repository<Faculty> facultyRepository;

    public DepartmentServiceImpl() {
        departmentRepository = new DepartmentRepository();
        facultyRepository = new FacultyRepository();
    }

    @Override
    public List<Department> getAllDepartmens() {
        List<Department> departments = departmentRepository.getAll();
        return departments;
    }

    @Override
    public Department saveOrUpdate(Department department) throws Exception {
       try{
           Department newDepartment = departmentRepository.saveOrUpdate(department);
           return newDepartment;
       }catch (Exception e){
           throw new Exception(Messages.DEPARTMENT_ALREADY_EXIST.getMessage());
       }
    }

    @Override
    public Department findById(long id) {
        Department department = departmentRepository.getById(id);
        return department;
    }

    @Override
    public void delete(Department department) {
        Faculty faculty = department.getFaculty();
        faculty.removeDepartment(department);
        departmentRepository.delete(department);
        facultyRepository.saveOrUpdate(faculty);
    }


}
