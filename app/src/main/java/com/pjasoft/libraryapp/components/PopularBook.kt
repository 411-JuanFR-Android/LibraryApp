package com.pjasoft.libraryapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.pjasoft.libraryapp.models.Book
import com.pjasoft.libraryapp.models.books
import com.pjasoft.libraryapp.ui.theme.LibraryAppTheme
//Lambdas!!!
// Callbacks -----> Pasar funciones como argumentos
// (Int,Int) -> Int
@Composable
fun PopularBook(
    book: Book,
    navController: NavController
){
    Box(
        modifier = Modifier
            .padding(10.dp)
            .width(130.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.tertiary)
            .clickable{
                navController.navigate("books/${book.id}")
            }
    ) {

        Text(
            text = book.title.take(2).uppercase(),
            modifier = Modifier
                .align(Alignment.Center),
            color = MaterialTheme.colorScheme.onPrimary
        )
        AsyncImage(
            model = book.image,
            contentDescription = book.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = book.title,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onPrimary)
                .padding(5.dp),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun PopularBookPreview(){
    LibraryAppTheme {
        PopularBook(
            book = books[1],
            navController = rememberNavController()
        )
    }
}