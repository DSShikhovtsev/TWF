package ru.twf.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO2 {
    private List<UserDTO> users;
}
