package com.humayun.userservice.service;

import com.humayun.userservice.VO.Department;
import com.humayun.userservice.VO.UserResponseWithDepartment;
import com.humayun.userservice.entity.User;
import com.humayun.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside save user of user service");
        return userRepository.save(user);
    }

    public UserResponseWithDepartment getUserWithDepartment(Long userId) {
        log.info("Inside get user of user service");
        UserResponseWithDepartment vo = new UserResponseWithDepartment();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ user.getDepartmentId(),
                Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
