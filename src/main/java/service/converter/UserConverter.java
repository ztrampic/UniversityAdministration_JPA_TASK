package service.converter;

import domain.User;
import dto.UserDtoResponse;

public interface UserConverter {
    UserDtoResponse convertToUserDtoResponse(User user);
}
