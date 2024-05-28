package com.project.register.service;

import com.project.register.model.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private List<Member> members = new ArrayList<>();

    // Lưu thành viên vào danh sách
    public void save(Member member) {
        members.add(member);
    }

    // Kiểm tra xem email đã tồn tại hay chưa
    public boolean emailExists(String email) {
        return members.stream().anyMatch(member -> member.getEmail().equals(email));
    }

    // Lấy tất cả các thành viên
    public List<Member> findAll() {
        return new ArrayList<>(members);  // Trả về bản sao của danh sách để tránh thay đổi trực tiếp
    }

    // Tìm thành viên theo email
    public Optional<Member> findByEmail(String email) {
        return members.stream().filter(member -> member.getEmail().equals(email)).findFirst();
    }

    // Cập nhật thông tin thành viên
    public boolean updateMember(String email, Member updatedMember) {
        Optional<Member> existingMemberOpt = findByEmail(email);
        if (existingMemberOpt.isPresent()) {
            Member existingMember = existingMemberOpt.get();
            existingMember.setPassword(updatedMember.getPassword());
            existingMember.setName(updatedMember.getName());
            existingMember.setBirthDate(updatedMember.getBirthDate());
            existingMember.setGender(updatedMember.getGender());
            existingMember.setEducation(updatedMember.getEducation());
            existingMember.setAddress(updatedMember.getAddress());
            existingMember.setPhone(updatedMember.getPhone());
            return true;
        }
        return false;
    }

    // Xóa thành viên theo email
    public boolean deleteByEmail(String email) {
        return members.removeIf(member -> member.getEmail().equals(email));
    }
}
