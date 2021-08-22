package com.humayun.userservice.VO;

import com.humayun.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseWithDepartment {

    private User user;
    private Department department;
}
