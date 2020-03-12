package service;

import domain.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartmens();

    Department saveOrUpdate(Department department);

    Department findById(long id);

    void delete(Department department);
}
