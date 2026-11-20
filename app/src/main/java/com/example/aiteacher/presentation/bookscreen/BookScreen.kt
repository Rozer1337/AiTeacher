package com.example.aiteacher.presentation.bookscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aiteacher.R
import com.example.aiteacher.ui.theme.literataFont
import com.example.aiteacher.ui.theme.onsetFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookScreen() {
    Scaffold(
        containerColor = Color(0xFFF5F2EA),
        topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFF5F2EA)
            ),
            title = {},
            navigationIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_left_small),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 26.dp)
                        .size(22.dp),
                    tint = Color(0xFF1D1C1A)
                )
            },
            actions = {
                Icon(
                    painter = painterResource(R.drawable.ic_dots_vertical),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 26.dp)
                        .size(24.dp),
                    tint = Color(0xFF1D1C1A)
                )
            }
        )
    }
) { innerPadding ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 26.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(width = 78.dp, height = 104.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF2F5D50))
            ) {
                Text(
                    text = "§",
                    color = Color.White,
                    fontSize = 90.sp,
                    fontFamily = literataFont,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 4.dp, y = 5.dp)
                        .alpha(0.12f)
                        .requiredHeight(200.dp)
                )

                Text(
                    text = "Биология",
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 10.dp, bottom = 9.dp),
                    color = Color.White,
                    fontFamily = literataFont,
                    fontWeight = W600,
                    fontSize = 12.sp
                )
            }

            Spacer(Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Биология, 6 класс",
                    fontFamily = literataFont,
                    fontWeight = W600,
                    fontSize = 23.sp,
                    color = Color(0xFF171614),
                    maxLines = 1
                )

                Text(
                    text = "148 страниц · 32 параграфа",
                    fontFamily = onsetFont,
                    fontSize = 13.sp,
                    color = Color(0xFF5E5A52)
                )

                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color(0xFFE4ECE5))
                        .padding(
                            horizontal = 10.dp,
                            vertical = 5.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_check),
                        contentDescription = null,
                        tint = Color(0xFF2F5D50),
                        modifier = Modifier.size(15.dp)
                    )

                    Spacer(Modifier.width(5.dp))

                    Text(
                        text = "Готов к работе",
                        fontFamily = onsetFont,
                        fontSize = 12.sp,
                        fontWeight = W600,
                        color = Color(0xFF2F5D50)
                    )
                }
            }
        }

        Spacer(Modifier.height(22.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .clip(RoundedCornerShape(17.dp))
                .background(Color(0xFFEAE5D9))
                .padding(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(13.dp))
                    .background(Color(0xFFFFFDF8)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Чаты · 3",
                    fontFamily = onsetFont,
                    fontSize = 14.sp,
                    fontWeight = W600,
                    color = Color(0xFF171614)
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Оглавление",
                    fontFamily = onsetFont,
                    fontSize = 14.sp,
                    fontWeight = W500,
                    color = Color(0xFF5E5A52)
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(Color(0xFF3544A8)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_plus),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(22.dp)
            )

            Spacer(Modifier.width(10.dp))

            Text(
                text = "Новый чат",
                fontFamily = onsetFont,
                fontSize = 15.sp,
                fontWeight = W600,
                color = Color.White
            )
        }

        Spacer(Modifier.height(14.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                ChatRow(
                    title = "Подготовка к контрольной",
                    subtitle = "§ 8 · План пересказа",
                    date = "Сегодня",
                    iconBackground = Color(0xFFE6E9F8),
                    iconTint = Color(0xFF3544A8)
                )
            }

            item {
                ChatRow(
                    title = "Домашка на среду",
                    subtitle = "§ 11 · Вопросы для самопроверки",
                    date = "Вчера",
                    iconBackground = Color(0xFFFFF2C9),
                    iconTint = Color(0xFF795B13)
                )
            }

            item {
                ChatRow(
                    title = "Повторение главы 2",
                    subtitle = "§ 6 · Краткое содержание",
                    date = "12 сент.",
                    iconBackground = Color(0xFFE2ECE6),
                    iconTint = Color(0xFF2F5D50)
                )
            }
        }
    }
}
}

@Composable
private fun ChatRow(
    title: String,
    subtitle: String,
    date: String,
    iconBackground: Color,
    iconTint: Color
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(13.dp))
                    .background(iconBackground),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_check),
                    contentDescription = null,
                    tint = iconTint,
                    modifier = Modifier.size(21.dp)
                )
            }

            Spacer(Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontFamily = onsetFont,
                    fontWeight = W600,
                    fontSize = 15.sp,
                    color = Color(0xFF171614),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = subtitle,
                    fontFamily = onsetFont,
                    fontSize = 13.sp,
                    color = Color(0xFF5E5A52),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(Modifier.width(8.dp))

            Text(
                text = date,
                fontFamily = onsetFont,
                fontSize = 11.sp,
                color = Color(0xFF5E5A52),
                modifier = Modifier.align(Alignment.Top)
            )
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = Color(0xFFE3DDD0)
        )
    }
}

@Composable
@Preview()
fun BookScreenPreview() {
    BookScreen()
}