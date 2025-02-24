package org.example.models.rest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SystemUser {
    private String username;
    private String dateJoined;
}
