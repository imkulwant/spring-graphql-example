package com.kulsin.post

import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class PostDao {

    private val posts: List<Post> = emptyList()

    fun getRecentPosts(count: Int, offset: Int): List<Post> {
        return posts.stream()
            .skip(offset.toLong())
            .limit(count.toLong())
            .collect(Collectors.toList())
    }

    fun getAuthorPosts(author: String): List<Post> {
        return posts.stream()
            .filter { post: Post -> author == post.authorId }
            .collect(Collectors.toList())
    }

    fun savePost(post: Post) {
        posts.plus(post)
    }

}