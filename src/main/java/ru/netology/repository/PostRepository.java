package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Post;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@Repository
// Stub
public class PostRepository {
    private Long idPost = 0L;

    private HashMap<Long, Post> basePost = new HashMap<>();

    public List<Post> all() {
        return basePost.values().stream().toList();
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(basePost.get(id));
    }

    public synchronized Post save(Post post) {
        if (post.getId() == 0) {
            idPost++;
            post.setId(idPost);
            basePost.put(idPost, post);
        }
        basePost.put(post.getId(), post);
        return post;
    }

    public void removeById(long id) {
        basePost.remove(id);
    }
}
