package gr.aueb.cf.springstarter4.validator;

import gr.aueb.cf.springstarter4.dto.StudentInsertDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class StudentInsertValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return StudentInsertDTO.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentInsertDTO studentInsertDto = (StudentInsertDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "empty");
        if (studentInsertDto.getFirstname().length() < 3 || studentInsertDto.getFirstname().length() > 50) {
            errors.rejectValue("firstname", "size");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "empty");
        if (studentInsertDto.getLastname().length() < 3 || studentInsertDto.getLastname().length() > 50) {
            errors.rejectValue("lastname", "size");
        }
    }
}
