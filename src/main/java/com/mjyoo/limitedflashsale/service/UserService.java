package com.mjyoo.limitedflashsale.service;

import com.mjyoo.limitedflashsale.dto.SignupRequestDto;
import com.mjyoo.limitedflashsale.entity.User;
import com.mjyoo.limitedflashsale.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signup(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        //email 중복 확인
        Optional<User> checkEmail = userRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new IllegalArgumentException("이미 사용중인 Email 입니다.");
        }

        //회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUsername(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("이미 사용중인 사용자 이름입니다.");
        }

        User user = User.builder()
                .email(email)
                .username(username)
                .password(password)
                .phoneNumber(requestDto.getPhoneNumber())
                .address(requestDto.getAddress())
                .build();
        userRepository.save(user);
    }
}
