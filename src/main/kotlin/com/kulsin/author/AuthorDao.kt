package com.kulsin.author

import org.springframework.stereotype.Component

@Component
class AuthorDao {

    private val authors: List<Author> = emptyList()

    fun getAuthor(id: String): Author {
        return authors.stream()
            .filter { author: Author -> id == author.id }
            .findFirst()
            .orElseThrow { RuntimeException() }
    }

}