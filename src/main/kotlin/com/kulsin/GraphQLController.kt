package com.kulsin

import com.kulsin.author.Author
import com.kulsin.author.AuthorDao
import com.kulsin.post.Post
import com.kulsin.post.PostDao
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller
import java.util.UUID


@Controller
class GraphQLController(
    var postDao: PostDao,
    var authorDao: AuthorDao
) {

    @QueryMapping
    fun recentPosts(@Argument count: Int, @Argument offset: Int): List<Any> {
        return postDao.getRecentPosts(count, offset)
    }

    @SchemaMapping(typeName = "Post", field = "author")
    fun author(post: Post): Author {
        return authorDao.getAuthor(post.authorId!!)
    }

    @MutationMapping
    fun createPost(
        @Argument title: String,
        @Argument text: String,
        @Argument category: String,
        @Argument authorId: String
    ): Post {

        val post = Post()
        post.id = UUID.randomUUID().toString()
        post.title = title
        post.category = category
        post.authorId = authorId

        postDao.savePost(post)

        return post
    }

}