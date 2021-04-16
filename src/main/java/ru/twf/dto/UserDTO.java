package ru.twf.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.twf.enums.Sex;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String about;

    private String city;

    private String region;

    private LocalDate birthday;

    private Sex sex;

    private Integer weight;
}
