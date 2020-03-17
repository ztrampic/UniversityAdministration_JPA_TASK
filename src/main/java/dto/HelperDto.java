package dto;

import enums.Title;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperDto {

    public Date formatStringToDate(String dateOfBirth) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(dateOfBirth);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Title setProfessorTitle(String title) {
        switch (title) {
            case "RESEARCHERS":
                return Title.RESEARCHERS;
            case "DOCTOR":
                return Title.DOCTOR;
            default:
                return Title.PROFESSOR;
        }
    }

    public String formatDateToString(Date workingStarted) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(workingStarted);
        return date;
    }
}
