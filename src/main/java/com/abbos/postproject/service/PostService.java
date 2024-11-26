package com.abbos.postproject.service;

import com.abbos.postproject.config.SessionUser;
import com.abbos.postproject.dto.Response;
import com.abbos.postproject.dto.request.PostCreateDTO;
import com.abbos.postproject.dto.request.PostUpdateDTO;
import com.abbos.postproject.dto.response.PostResponseDTO;
import com.abbos.postproject.entity.Post;
import com.abbos.postproject.entity.User;
import com.abbos.postproject.mapper.PostMapper;
import com.abbos.postproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  17:31
 **/
@Service
@RequiredArgsConstructor
public class PostService
        implements GenericCrudService<Long, Post, PostResponseDTO, PostCreateDTO, PostUpdateDTO> {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final SessionUser sessionUser;

    private final UserService userService;

    @Override
    @Transactional
    public Response<PostResponseDTO> create(PostCreateDTO dto) {
        Post post = postMapper.fromCreate(dto);

        User user = userService.findById(sessionUser.id());
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        post.setUser(user);

        Post savedPost = postRepository.save(post);
        return Response.ok(postMapper.toDTO(savedPost));
    }

    @Override
    @Transactional
    public Response<Boolean> update(PostUpdateDTO dto) {
        Post post = postRepository.findByIdCustom(dto.id());
        User user = post.getUser();
        if (user.getId().equals(sessionUser.id())) {
            post.setTitle(dto.title());
            post.setContent(dto.content());
            postRepository.save(post);
            return Response.ok(true);
        }
        return Response.ok(false, -4190, false);
    }

    @Override
    @Transactional
    public Response<Boolean> delete(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        assert post != null;
        User user = post.getUser();
        if (user.getId().equals(sessionUser.id())) {
            postRepository.softDelete(id);
            return Response.ok(true);
        }
        return Response.ok(false, -5498, false);
    }


    @Override
    public Response<PostResponseDTO> find(Long id) {
        return Response.ok(postMapper.toDTO(postRepository.findByIdCustom(id)));
    }

    @Override
    public Response<List<PostResponseDTO>> findAll() {
        return Response.ok(postRepository.findAll().stream()
                .filter(post -> !post.isDeleted())
                .map(postMapper::toDTO)
                .toList());
    }
}
