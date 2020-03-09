package service.converter.impl;

import domain.Professor;
import domain.Student;
import domain.UserDetails;
import dto.HelperDto;
import dto.UserDetailsDto;
import service.converter.DepartmentConverter;
import service.converter.UserDetailsConverter;

public class UserDetailsConverterImpl implements UserDetailsConverter {
    private final DepartmentConverter departmentConverter;
    private final HelperDto helperDto;

    public UserDetailsConverterImpl() {
        departmentConverter = new DepartmentConverterImpl();
        helperDto = new HelperDto();
    }

    @Override
    public UserDetailsDto convertToDto(UserDetails userDetails) {
        UserDetailsDto userDetailsDto = new UserDetailsDto();
       if(userDetails.getClass().equals(Professor.class)){
          userDetailsDto.setTitle(((Professor) userDetails).getTitle());
          userDetailsDto.setWorkingStarted(((Professor) userDetails).getWorkingStarted().toString());
          userDetailsDto.setDepartmentDto(departmentConverter.convertToDto(((Professor) userDetails).getDepartment()));
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

    @Override
    public UserDetails convertToStudentEntity(UserDetailsDto userDetailsDto) {
        Student student = new Student();
        student.setDateOfBirth(helperDto.formatStringToDate(userDetailsDto.getDateOfBirth()));
        student.setIndexNumber(userDetailsDto.getIndexNumber());
        student.setFirstName(userDetailsDto.getFirstName());
        student.setLastName(userDetailsDto.getLastName());
        return student;
    }

}
