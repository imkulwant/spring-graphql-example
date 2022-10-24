package com.kulsin.post

import lombok.Data
import java.util.*

@Data
class Post {

    var id: String? = null
    var title: String? = null
    var category: String? = null
    var authorId: String? = null

}