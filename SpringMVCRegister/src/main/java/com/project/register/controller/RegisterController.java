package com.project.register.controller;

import com.project.register.model.Member;
import com.project.register.service.MemberService;
import com.project.register.validator.MemberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberValidator memberValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(memberValidator);
    }

    @RequestMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("member", new Member());
        return "register";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("member") Member member, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        memberService.save(member);
        model.addAttribute("message", "Đăng ký thành công!");
        return "result";
    }
}
