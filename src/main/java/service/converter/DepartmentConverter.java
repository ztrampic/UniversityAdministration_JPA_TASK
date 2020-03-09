package service.converter;

import domain.Department;
import dto.DepartmentDto;

import java.util.Set;

public interface DepartmentConverter {
    DepartmentDto convertToDto(Department department);

    Set<DepartmentDto> convertToDtoSet(Set<Department> departmentSet);
}
