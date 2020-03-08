package service.converter.impl;

import domain.Professor;
import domain.Student;
import domain.UserDetails;
import dto.UserDetailsDto;
import service.converter.UserDetailsConverter;

public class UserDetailsConverterImpl implements UserDetailsConverter {
    @Override
    public UserDetailsDto convertToDto(UserDetails userDetails) {
        UserDetailsDto userDetailsDto = new UserDetailsDto();
       if(userDetails.getClass().equals(Professor.class)){
          userDetailsDto.setTitle(((Professor) userDetails).getTitle());
          userDetailsDto.setWorkingStarted(((Professor) userDetails).getWorkingStarted().toString());
       }else if(userDetails.getClass().equals(Student.class)){
           userDetailsDto.setDateOfBirth(((Student) userDetails).getDateOfBirth().toString());
           userDetailsDto.setIndexNumber(((Student) userDetails).getIndexNumber());
        }
        userDetailsDto.setId(userDetails.getId_user_details());
        userDetailsDto.setFirstName(userDetails.getFirstName());
        userDetailsDto.setLastName(userDetails.getLastName());
        System.out.println(userDetails.getClass());
        return userDetailsDto;
    }
}
