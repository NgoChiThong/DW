package com.project.register.validator;

import com.project.register.model.Member;
import com.project.register.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class MemberValidator implements Validator {

    @Autowired
    private MemberService memberService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Member.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member member = (Member) target;

        // Validate email
        if (memberService.emailExists(member.getEmail())) {
            errors.rejectValue("email", "error.member", "Email này đã có người đăng ký. Thử lại.");
        }

        // Validate birth date format
        if (member.getBirthDate() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            try {
                dateFormat.parse(member.getBirthDate().toString());
            } catch (ParseException e) {
                errors.rejectValue("birthDate", "error.member", "Ngày không hợp lệ. Thử lại.");
            }
        }

        // Validate password match
        if (!member.getPassword().equals(member.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "error.member", "Mật khẩu không tương ứng. Thử lại.");
        }
    }
}
