package com.hw_w2.homework.w2.controller;

import com.hw_w2.homework.w2.advices.ApiResponse;
import com.hw_w2.homework.w2.dto.student.StudentRequest;
import com.hw_w2.homework.w2.dto.student.StudentResponse;
import com.hw_w2.homework.w2.dto.student.StudentUpdateRequest;
import com.hw_w2.homework.w2.service.StudentService;
import com.hw_w2.homework.w2.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    // CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponse>> create(
            @RequestBody StudentRequest request) {

        return ResponseUtil.success(
                studentService.create(request),
                HttpStatus.CREATED
        );
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponse>>> getAll() {

        return ResponseUtil.success(
                studentService.getAll()
        );
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> getById(
            @PathVariable Long id) {

        return ResponseUtil.success(
                studentService.getById(id)
        );
    }

    // UPDATE (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> update(
            @PathVariable Long id,
            @RequestBody StudentUpdateRequest request) {

        return ResponseUtil.success(
                studentService.update(id, request)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> delete(
            @PathVariable Long id) {

        return ResponseUtil.success(
                studentService.delete(id)
        );
    }

    @PostMapping("/{studentId}/enroll/{subjectId}")
    public ResponseEntity<?> enrollStudent(@PathVariable Long studentId, @PathVariable Long subjectId) {
        studentService.addSubject(studentId, subjectId);
        return ResponseUtil.success("Enrolled student successfully to subject!");
    }

    @PostMapping("/{studentId}/disenroll/{subjectId}")
    public ResponseEntity<?> disEnrollStudent(@PathVariable Long studentId, @PathVariable Long subjectId) {
        studentService.removeSubject(studentId, subjectId);
        return ResponseUtil.success("DisEnrolled student successfully to subject!");
    }
}