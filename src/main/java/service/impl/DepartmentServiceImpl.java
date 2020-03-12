package service.impl;

import domain.Department;
import repository.Repository;
import repository.impl.DepartmentRepository;
import service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{

    private final Repository<Department> departmentRepository;

    public DepartmentServiceImpl() {
        departmentRepository = new DepartmentRepository();
    }

    @Override
    public List<Department> getAllDepartmens() {
        List<Department> departments = departmentRepository.getAll();
        return departments;
    }

    @Override
    public Department saveOrUpdate(Department department) {
        Department newDepartment = departmentRepository.saveOrUpdate(department);
        return newDepartment;
    }

    @Override
    public Department findById(long id) {
        Department department = departmentRepository.getById(id);
        return department;
    }

    @Override
    public void delete(Department department) {
        departmentRepository.delete(department);
    }


}
