package service.converter;

import domain.Department;
import dto.DepartmentDto;

public interface DepartmentConverter {
    DepartmentDto convertToDto(Department department);
}
