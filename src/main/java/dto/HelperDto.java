package dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperDto {

    public Date formatStringToDate(String dateOfBirth) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = simpleDateFormat.parse(dateOfBirth);
            return date;
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }
}
