package dto;

import java.util.Set;

public class FacultyDto {
    private Long id;
    private String name;
    private String address;
    private Set<DepartmentDto> departmentDtoSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<DepartmentDto> getDepartmentDtoSet() {
        return departmentDtoSet;
    }

    public void setDepartmentDtoSet(Set<DepartmentDto> departmentDtoSet) {
        this.departmentDtoSet = departmentDtoSet;
    }
}
