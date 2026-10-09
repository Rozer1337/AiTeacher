package com.example.aiteacher.presentation.newbook

import android.widget.ImageButton
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aiteacher.R
import com.example.aiteacher.model.Book
import com.example.aiteacher.presentation.mainscreen.MainScreen
import com.example.aiteacher.ui.theme.literataFont
import com.example.aiteacher.ui.theme.onsetFont
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewBookScreen() {
    val viewmodel = koinViewModel<NewBookViewmodel>()

    val pdfPicker = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        if (uri!=null) {
            viewmodel.pdfUpload(uri)
        }
    }
    Scaffold(
        containerColor = Color(0xFFF5F2EA),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF5F2EA),
                ),
                title = {
                    Text(
                        text = stringResource(R.string.new_book),
                        fontWeight = W600,
                        fontFamily = onsetFont,
                        fontSize = 17.sp
                    )
                },
                navigationIcon = {
                    Image(
                        painter = painterResource(R.drawable.ic_cross),
                        contentDescription = "Exit",
                        modifier = Modifier.padding(12.dp)
                    )
                }
            )
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = 20.dp)
                .fillMaxSize()
        ) {
            PdfCard(onClick = {pdfPicker.launch(arrayOf("application/pdf"))})

            Spacer(Modifier.height(20.dp))

            EnterLabel("Название")

            Spacer(Modifier.height(8.dp))

            TextEnter(
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    EnterLabel("Предмет")

                    Spacer(Modifier.height(8.dp))

                    TextEnter(
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    EnterLabel("Класс")

                    Spacer(Modifier.height(8.dp))

                    TextEnter(
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(Modifier.height(20.dp))

            ProgressCard()

            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun PdfCard(onClick : () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFDF8)
        ),
        onClick = onClick,
        border = BorderStroke(1.dp, Color(0xFFE3DDD0))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(width = 48.dp, height = 56.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFF3E1DC)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "PDF",
                    fontSize = 12.sp,
                    fontWeight = W700,
                    color = Color(0xFFB54838)
                )
            }

            Spacer(Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "biologiya-6-klass.pdf",
                    fontSize = 15.sp,
                    fontWeight = W600,
                    color = Color(0xFF1D1C1A),
                    maxLines = 1,
                    fontFamily = onsetFont
                )

                Spacer(Modifier.height(2.dp))

                Text(
                    text = "18,4 МБ · 148 страниц",
                    fontSize = 13.sp,
                    color = Color(0xFF5E5A52),
                    fontFamily = onsetFont
                )
            }

            Text(
                text = "Заменить",
                fontSize = 14.sp,
                fontWeight = W600,
                fontFamily = onsetFont,
                color = Color(0xFF2F3E9E)
            )
        }
    }
}


@Composable
private fun EnterLabel(text: String) {
    Text(
        text = text,
        fontSize = 13.sp,
        fontFamily = onsetFont,
        fontWeight = W600,
        color = Color(0xFF5E5A52)
    )
}

@Composable
private fun TextEnter(
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
        singleLine = true,
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFFFFDF8),
            unfocusedContainerColor = Color(0xFFFFFDF8),
            focusedBorderColor = Color(0xFFD9D2C3),
            unfocusedBorderColor = Color(0xFFD9D2C3),
            focusedTextColor = Color(0xFF1D1C1A),
            unfocusedTextColor = Color(0xFF1D1C1A),
            cursorColor = Color.Unspecified
        ),
        textStyle = LocalTextStyle.current.copy(
            fontSize = 16.sp,
            fontFamily = onsetFont
        )
    )
}

@Composable
private fun ProgressCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFDF8)
        ),
        border = BorderStroke(1.dp, Color(0xFFD9D2C3))
    ) {
        Column(
            modifier = Modifier.padding(
                start = 16.dp,
                top = 18.dp,
                end = 16.dp,
                bottom = 18.dp
            )
        ) {
            Text(
                text = stringResource(R.string.prepare_book),
                fontWeight = W600,
                fontFamily = literataFont,
                fontSize = 20.sp
            )

            Spacer(Modifier.height(16.dp))

        }
    }
}

@Composable
@Preview()
fun NewBookScreenPreview() {
    NewBookScreen()
}

//Доделать экран, кнопку продолжить в фоне не нужно