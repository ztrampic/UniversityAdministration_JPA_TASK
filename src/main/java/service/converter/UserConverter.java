package service.converter;

import domain.Professor;
import domain.User;
import dto.ProfessorDtoRequest;
import dto.ProfessorDtoResponse;
import dto.StudentDtoRequest;
import dto.UserDtoResponse;

import java.util.Set;

public interface UserConverter {
    UserDtoResponse convertToUserDtoResponse(User user);

    User convertToUser(StudentDtoRequest studentDtoRequest);

    User convertToUserProfessor(ProfessorDtoRequest professorDtoRequest);

    Set<ProfessorDtoResponse> convertSetToSetProfessorDto(Set<Professor> professors);
    ProfessorDtoResponse convertToProfessorDto(Professor professor);
}
