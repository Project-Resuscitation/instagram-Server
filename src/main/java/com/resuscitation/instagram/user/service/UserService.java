package com.resuscitation.instagram.user.service;

import com.resuscitation.instagram.user.dto.*;
import com.resuscitation.instagram.user.entity.UserEntity;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    /**
     * 회원 가입 메소드
     *
     * @param registerFormDto 회원 가입 폼
     * @return JSON Web Tokens
     * @author cmsong111
     */
    JwtDto register(RegisterFormDto registerFormDto) throws IllegalArgumentException;

    /**
     * 이메일 중복 체크 메소드
     *
     * @param email 사용할 이메일
     * @return 사용 가능 true, 사용 불가능 false
     */
    boolean emailDuplicateCheck(String email);

    /**
     * 회원 가입 - Facebook
     *
     * @param facebookCode 회원 가입 토큰
     * @return JSON Web Tokens
     */
    String registerWithFaceBook(String facebookCode);

    /**
     * 로그인
     *
     * @param loginFormDto 로그인 폼 DTO (email, password)
     * @return JSON Web Tokens
     */
    JwtDto login(LoginFormDto loginFormDto);

    /**
     * 로그인 - Facebook
     *
     * @param facebookCode Facebook Oauth Code
     * @return JSON Web Tokens
     */
    String loginWithFacebook(String facebookCode);

    /**
     * 유저 정보 불러오기
     *
     * @param req HttpServletRequest
     * @return UserEntity
     */
    UserEntity whois(HttpServletRequest req);

    /**
     * 회원 탈퇴 메소드
     *
     * @param req HttpServletRequest
     * @return 회웥 탈퇴 성공시 true 반환
     */
    boolean deleteUser(HttpServletRequest req);

    /**
     * 프로필 수정 메소드
     *
     * @param req            HttpServletRequest
     * @param editProfileDto EditProfileDto
     * @return 저장된 유저 정보 반환
     */
    UserEntity editProfile(HttpServletRequest req, EditProfileDto editProfileDto);

    /**
     * 패스워드 수정 메소드
     *
     * @param req                   HttpServletRequest
     * @param passwordChangeFormDto 비밀번호 변경 폼
     * @return 저장된 유저 정보 반환
     */
    UserEntity editPassword(HttpServletRequest req, PasswordChangeFormDto passwordChangeFormDto);
}
