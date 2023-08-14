package com.example.assignment13.Controller;


import com.example.assignment13.ApiResponse.ApiResponse;
import com.example.assignment13.Model.UserModel;
import com.example.assignment13.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    final private UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid UserModel user, Errors errors){
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid UserModel user, Errors errors,@PathVariable Integer id) {
        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if(userService.updateUser(user,id))
            return ResponseEntity.status(200).body(new ApiResponse("User updated"));
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        if(userService.deleteUser(id))
            return ResponseEntity.status(200).body(new ApiResponse("User Deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("Id not found"));
    }
}
