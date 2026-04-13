package com.pjasoft.libraryapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.pjasoft.libraryapp.models.Book
import com.pjasoft.libraryapp.models.books

@Composable
fun BookDetailScreen(
    id:Int
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Voy a emular que hago una peticion a una API / DB
        // MUY IMPORTANTE!!!!!
        val book = books.firstOrNull{ b -> b.id == id }

        // Con ciclo for
//        var bookFor : Book? = null
//        for(b in books){
//            if(b.id == id){
//                bookFor = b
//            }
//        }
        AsyncImage(
            model = book?.image,
            contentDescription = book?.title,
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = book?.title ?: "Sin titulo"
        )
        Text(
            text = book?.author ?: "Sin autor"
        )
    }
}