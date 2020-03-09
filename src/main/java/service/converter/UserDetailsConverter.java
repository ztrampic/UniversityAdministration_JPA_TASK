package service.converter;

import domain.UserDetails;
import dto.UserDetailsDto;

public interface UserDetailsConverter {
    UserDetailsDto convertToDto(UserDetails userDetails);

    UserDetails convertToStudentEntity(UserDetailsDto userDetailsDto);
}
