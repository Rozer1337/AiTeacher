package com.example.aiteacher.presentation.mainscreen

import android.annotation.SuppressLint
import android.widget.GridLayout
import androidx.compose.animation.core.SeekableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aiteacher.R
import com.example.aiteacher.model.Book
import com.example.aiteacher.ui.theme.literataFont
import com.example.aiteacher.ui.theme.onsetFont
import java.util.Locale
import java.util.Locale.getDefault


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(listOfBooks : List<Book>, onAddBookClick : () -> Unit) {
    Scaffold(
        containerColor = Color(0xFFF5F2EA),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF5F2EA)
                ),
                title = { Text(
                    text = stringResource(R.string.books),
                    fontWeight = W600,
                    fontFamily = literataFont,
                    fontSize = 28.sp
                ) },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search",
                        )
                    }
                }

            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onAddBookClick,
                containerColor = Color(0xFF2F3E9E),
                contentColor = Color.White,
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = "Search",
                    )
                },
                text = {
                    Text(
                        text = stringResource(R.string.add_pdf),
                        fontFamily = onsetFont,
                        fontWeight = W600,
                        fontSize = 15.sp
                    )
                },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(innerPadding),
        ) {
            Continue()

            Spacer(modifier = Modifier.height(20.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF5F2EA)),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            )
            {
                item(
                    span = { GridItemSpan(maxLineSpan) }
                ) {
                    Text(
                        text = "Все учебники · 4",
                        fontSize = 13.sp,
                        color = Color(0xFF5E5A52),
                        fontWeight = W600,
                        fontFamily = onsetFont,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                }

                items(
                    items = listOfBooks,
                ) {
                    BookCard(
                        grade = it.grade,
                        name = it.name,
                        paragraphs = it.paragraphs,
                        chatsCount = it.chatsCount
                    )
                }
            }
        }

    }
}

@Composable
@Preview()
fun MainScreenPreview() {
    MainScreen(
        listOf(
            Book("6 класс", "Биология", 32, 3),
            Book("6 класс", "История России", 24, 1),
            Book("6 класс", "Биология", 32, 3)),
        onAddBookClick = {}
    )
}

@Composable
private fun BookCard(
    grade : String,
    name : String,
    paragraphs : Int,
    chatsCount : Int
) {
    Column(
        modifier = Modifier.width(168.dp)
    ) {
        Card(
            shape = RoundedCornerShape(14.dp),
            elevation = CardDefaults.cardElevation(0.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier.width(168.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth()
                .height(154.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(Color(0xff2f5d50)),
            ) {
                Text(
                    text = grade.uppercase(),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(14.dp)
                        .alpha(0.85f),
                    fontFamily = onsetFont,
                    color = Color(0xFFF5F2EA),
                    fontSize = 12.sp
                )

                Text(
                    text = "§",
                    color = Color.White,
                    fontSize = 140.sp,
                    fontFamily = literataFont,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 10.dp, y = (-44).dp)
                        .alpha(0.12f)
                        .requiredHeight(200.dp)
                )

                Text(
                    text = name,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(
                            start = 14.dp,
                            bottom = 11.dp
                        ),
                    fontFamily = literataFont,
                    fontWeight = W600,
                    fontSize = 22.sp,
                    color = Color.White,
                    lineHeight = 24.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$name. $grade",
                fontSize = 15.sp,
                fontWeight = W600,
                fontFamily = onsetFont,
                maxLines = 1,
                style = TextStyle(),
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "$chatsCount чата · $paragraphs параграфа",
                color = Color(0xFF5E5A52),
                fontFamily = onsetFont,
                fontSize = 13.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@Composable
private fun Continue() {
    Row(
        modifier = Modifier
            .height(76.dp)
            .fillMaxWidth(),
    ) {
        Card(
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1D1C1A)
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFF4D35E)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "§ 8",
                        fontWeight = W700,
                        fontSize = 18.sp,
                        fontFamily = literataFont,
                        color = Color(0xFF171614)
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.continue_)
                            .uppercase(getDefault()),
                        color = Color(0xFFCFC8B8),
                        fontSize = 12.sp,
                        letterSpacing = 0.6.sp,
                        fontFamily = onsetFont
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "Биология · план пересказа",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = W600,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = onsetFont
                    )
                }

                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}
//доделать дизайн этого экрана