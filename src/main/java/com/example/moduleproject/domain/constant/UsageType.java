package com.example.moduleproject.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UsageType {
    MONTHLY_RENT("월세"),
    CELL_PHONE_BILL("휴대폰 요금"),
    PREMIUM("보험료"),
    TRANSPORT_FEE("교통비"),
    UTILITIES("공과금"),
    ELECTRICITY_BILL("전기세"),
    WATER_BILL("수도세"),
    HEATING_BILL("난방비"),
    ETC("기타"),
    ;


    @Getter private final String value;
}
