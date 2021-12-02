package com.grupounoptresunal.kamaleon.data.repositories

import com.grupounoptresunal.kamaleon.data.mocks.CommentMock
import com.grupounoptresunal.kamaleon.data.models.Comment


class CommentRepository(private val dataSource: CommentMock) {
    suspend fun loadComment(): List<Comment>{
        return dataSource.loadComments()
    }
}