package ru.twf.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MemberQuentity {

    ten(10L),
    thirty(30L),
    fifty(50L),
    oneHundred(100L),
    infinity(Long.MAX_VALUE);

    private final Long size;
}
