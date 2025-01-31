/*
package com.mjyoo.limitedflashsale.auth.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjyoo.limitedflashsale.auth.dto.LoginRequestDto;
import com.mjyoo.limitedflashsale.user.entity.UserRoleEnum;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

*/
/**
 * UsernamePasswordAuthenticationFilter는 스프링 시큐리티의 기본 로그인 처리 필터로
 * 기본적으로 session 방식으로 동작함
 * 토큰 기반 인증을 구현하려면 customized filter 사용해서 구현이 필요
 *//*

@Slf4j(topic = "로그인 및 JWT 생성")
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    //JWT 토큰 생성을 위한 JwtUtil 주입
    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        setFilterProcessesUrl("/api/auth/login");
    }

    //로그인 요청을 처리 (사용자 정보를 읽고 인증 시도)
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info("로그인 시도");
        try { //request.getInputStream()을 통해 request body에 있는 JSON 데이터를 읽어와서 LoginRequestDto 객체로 변환
            LoginRequestDto requestDto = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDto.class);
            return getAuthenticationManager().authenticate( //인증 매니저에게 인증을 요청
                    new UsernamePasswordAuthenticationToken(
                            requestDto.getEmail(),
                            requestDto.getPassword(),
                            null
                    )
            );
        } catch (IOException e) {
            log.error("로그인 요청 처리 중 오류: {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    //인증 성공시 successfulAuthentication 메서드 실행
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("로그인 성공 및 JWT 생성");
        //UserDetailsImpl을 통해 사용자 정보를 가져옴
        String email = ((UserDetailsImpl) authResult.getPrincipal()).getEmail();
        UserRoleEnum role = ((UserDetailsImpl) authResult.getPrincipal()).getUser().getRole();

        //사용자 정보를 바탕으로 JWT 토큰 생성
        String token = jwtUtil.createAccessToken(email, role);
        //생성된 JWT을 응답 헤더(Authorization)에 추가
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, token);
    }

    //인증 실패시 unsuccessfulAuthentication 메서드 실행
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        log.info("로그인 실패");
    }
}
*/
