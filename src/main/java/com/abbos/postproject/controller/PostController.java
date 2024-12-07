package com.abbos.postproject.controller;

import com.abbos.postproject.dto.Response;
import com.abbos.postproject.dto.request.PostCreateDTO;
import com.abbos.postproject.dto.request.PostUpdateDTO;
import com.abbos.postproject.dto.response.PostResponseDTO;
import com.abbos.postproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  17:00
 **/
@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Response<PostResponseDTO>> create(@RequestBody PostCreateDTO dto) {
        return ResponseEntity.ok(postService.create(dto));
    }

    @PutMapping("/update")
    public ResponseEntity<Response<Boolean>> update(@RequestBody PostUpdateDTO dto) {
        return ResponseEntity.ok(postService.update(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Boolean>> update(@PathVariable Long id) {
        return ResponseEntity.ok(postService.delete(id));
    }

    @GetMapping("/get")
    public ResponseEntity<Response<List<PostResponseDTO>>> getAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response<PostResponseDTO>> get(@PathVariable Long id) {
        return ResponseEntity.ok(postService.find(id));
    }
}
