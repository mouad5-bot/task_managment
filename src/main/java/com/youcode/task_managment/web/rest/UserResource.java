//package com.youcode.task_managment.web.rest;
//
//import com.youcode.task_managment.domain.User;
//import com.youcode.task_managment.dtos.UserDto;
//import com.youcode.task_managment.service.UserService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springdoc.api.annotations.ParameterObject;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/user")
//public class UserResource {
//    private final UserService userService;
//    private final UserMapper userMapper;
//    @PostMapping("add")
//    public ResponseEntity<User> add(@RequestBody @Valid UserDto userDto) throws Exception {
//        User save = userService.add(userMapper.toEntity(userDto));
//        return ResponseEntity.ok(save);
//    }
//
//    @GetMapping("all")
//    public ResponseEntity<List<UserDto>> getAllTasks(@ParameterObject Pageable pageable) {
//
//        List<User> userList = userService.getAll(pageable);
//
//        return ResponseEntity.ok(userList.stream()
//                .map(userMapper::toDto)
//                .toList()
//        );
//    }
//
//}
