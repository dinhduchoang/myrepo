package com.hoangd.identity_service.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
     String username;
    @Size(min = 8, message = "USER_VALID_PASSWORD")
     String password;
     String lastname;
     String firstname;
     LocalDate dob;
}
