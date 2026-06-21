package com.hoangd.identity_service.dto.response;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserReponse {
    String id;
    String username;
    String password;
    String lastname;
    String firstname;
    LocalDate dob;
}
