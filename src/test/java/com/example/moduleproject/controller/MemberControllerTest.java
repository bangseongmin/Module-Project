package com.example.moduleproject.controller;

import com.example.moduleproject.domain.Member;
import com.example.moduleproject.dto.MemberDto;
import com.example.moduleproject.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@DisplayName("컨트롤러 - 회원 관리")
@WebMvcTest(MemberController.class)
class MemberControllerTest {

    private final MockMvc mvc;
    private final ObjectMapper objectMapper;

    @MockBean private MemberService memberService;

    public MemberControllerTest(
            @Autowired MockMvc mvc,
            @Autowired ObjectMapper objectMapper
    ) {
        this.mvc = mvc;
        this.objectMapper = objectMapper;
    }

    @DisplayName("[POST] 회원가입 요청 - 정상호출")
    @Test
    void givenMemberInfo_whenRequestingRegisterMember_thenReturnNothing() throws Exception {
        // Given

        // When
        mvc.perform(post("/api/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(memberDto()))
                )
                .andExpect(status().isOk());

        // Then
        verify(memberService, times(1)).registerMember(any(MemberDto.class));
    }

    @DisplayName("[POST] 로그인 요청 - 정상호출")
    @Test
    void givenMemberInfo_whenRequestingLogin_thenReturnNothing() throws Exception {
        // Given
        willDoNothing().given(memberService).login(any(MemberDto.class));

        // When
        mvc.perform(post("/api/members/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(memberDto()))
                )
                .andExpect(status().isOk());

        // Then
        verify(memberService, times(1)).login(any(MemberDto.class));
    }

    private Member member() {
        return Member.builder()
                .username("artist")
                .password("pw")
                .birthday(LocalDate.of(2023, 3, 1))
                .age(23)
                .fullname("artist")
                .build();
    }

    private MemberDto memberDto() {
        return MemberDto.fromEntity(member());
    }
}