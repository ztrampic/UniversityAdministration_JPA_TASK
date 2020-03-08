package service.converter;

import domain.Faculty;
import dto.FacultyDto;

public interface FacultyConverter {
    FacultyDto convertToDto(Faculty faculty);
}
