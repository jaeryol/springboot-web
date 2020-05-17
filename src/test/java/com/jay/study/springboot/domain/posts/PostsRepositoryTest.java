package com.jay.study.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() { postsRepository.deleteAll(); }

    @Test
    public void posts_find_correctly() {
        // Arrange
        String title = "테스트 제목";
        String content = "테스트 본문 입니다.";
        String author = "Jaeryong@gmail.com";
        postsRepository.save(
                Posts.builder()
                        .title(title)
                        .content(content)
                        .author(author)
                        .build()
        );

        // Act
        List<Posts> actual = postsRepository.findAll();

        // Assert
        Posts posts = actual.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo(author);
    }

    @Test
    public void BaseTimeEntity_registers() {
        // Arrange
        LocalDateTime now = LocalDateTime.of(2020, 5, 17, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        // Act
        List<Posts> posts = postsRepository.findAll();

        // Assert
        Posts post = posts.get(0);
        assertThat(post.getCreatedDate()).isAfter(now);
        assertThat(post.getModifiedDate()).isAfter(now);
    }
}
