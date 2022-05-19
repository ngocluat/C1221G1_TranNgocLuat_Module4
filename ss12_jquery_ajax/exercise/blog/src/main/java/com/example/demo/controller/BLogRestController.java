package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Post;
import com.example.demo.service.IBlogService;
import com.example.demo.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
// ngăn cản sự bảo vệ
@RequestMapping("/rest-post")
@RestController
public class BLogRestController {

    @Autowired
    IBlogService iBlogService;


    @Autowired
    private IPostService IPostService;

    ///Xem danh sách các category
    // http://localhost:8080/rest-post/list-post
    @GetMapping("/list-post")
    public ResponseEntity<Page<Post>> getListPost(Pageable pageable) {
        Page<Post> posts = IPostService.findAll(pageable);
        if (!posts.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);

    }

    // Xem danh sách các bài viết.
    //http://localhost:8080/rest-post/list-blog
    @GetMapping("list-blog")
    public ResponseEntity<Page<Blog>> getLisstBlog(@PageableDefault(value = 4) Pageable pageable,
                                                   @RequestParam Optional<String> name,
                                                   @RequestParam Optional<String> author) {
        String key1 = name.orElse("");
        String key2 = author.orElse("");
        Page<Blog> allBlogs = iBlogService.findAllByNameBlogContaining(key1, pageable);
        if (!allBlogs.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
    }

    //Xem danh sách các bài viết của một category
    @GetMapping("/list-post-in-blog/{id}")
    public ResponseEntity<List<Blog>> findByPostInBlog(@PathVariable Long id) {
        Post post = IPostService.findById(id);
        List<Blog> allBlogs = post.getBlogList();
        if (allBlogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);

    }


    //Xem chi tiết một bài viết
    // http://localhost:8080/rest-post/view-blog/16
    @GetMapping("/view-blog/{id}")
    public ResponseEntity<Blog> viewblog(@PathVariable Long id) {
        Blog viewBlog = iBlogService.findById(id);
        if (viewBlog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(viewBlog, HttpStatus.OK);

    }

    @GetMapping("/search-blog")
    public ResponseEntity<Page<Blog>>
    findByNameBlogContainingAndAuthorContaining(@RequestParam Optional<String> name,
                                                @RequestParam Optional<String> author
            , Pageable pageable) {
        String key1 = name.orElse("");
        String key2 = author.orElse("");
        Page<Blog> viewBlog = iBlogService.findByNameBlogContainingAndAuthorContaining(key1, key2, pageable);
        if (!viewBlog.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(viewBlog, HttpStatus.OK);

    }


}
