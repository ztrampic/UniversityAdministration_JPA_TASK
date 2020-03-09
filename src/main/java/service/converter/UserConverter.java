package service.converter;

import domain.User;
import dto.StudentDtoRequest;
import dto.UserDtoResponse;

public interface UserConverter {
    UserDtoResponse convertToUserDtoResponse(User user);

    User convertToUser(StudentDtoRequest studentDtoRequest);
}
