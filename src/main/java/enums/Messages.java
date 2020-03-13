package enums;

public enum Messages {
    BAD_CREDENTIALS ("Bad credentials!"),
    SING_UP_SUCCESS("Success you can now login."),
    PASSWORDS_NOT_MATCH ("Passwords don`t match."),
    SUCCESS_FACULTY_INSERT ("Success updating Faculty info."),
    SOMETHING_WRONG("Something went wrong."),
    SUCCESS_REMOVE_DEPARTMENT ("Success deleting department."),
    DEPARTMENT_ALREADY_EXIST ("Department with that name alrady exist."),
    SUCCESS_ADD_DEPARTMENT ("Success adding new Department.");
    private final String message;

    Messages(String s) {
        message = s;
    }

    public String getMessage(){
        return this.message;
    }
}
