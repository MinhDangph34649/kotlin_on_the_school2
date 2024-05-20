package com.example.lab4_ph34649

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lab4_ph34649.ui.theme.Lab4_ph34649Theme

class Bai2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4_ph34649Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column {
                        DisplayIcon()
                        Spacer(modifier = Modifier.height(16.dp))
                        HorizontalImageList()
                        Spacer(modifier = Modifier.height(16.dp))
                        VerticalImageList()
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayIcon() {
    Image(
        painter = painterResource(id = R.drawable.ronaldo),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun HorizontalImageList() {
    val scrollState = rememberScrollState()
    Row(modifier = Modifier.horizontalScroll(scrollState)) {
        for (i in 1..10) {
            Image(
                painter = painterResource(id = R.drawable.im1), // Thay đổi bằng hình ảnh thực tế của bạn
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun VerticalImageList() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        for (i in 1..10) {
            Image(
                painter = painterResource(id = R.drawable.im2), // Thay đổi bằng hình ảnh thực tế của bạn
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f)
                    .clip(RoundedCornerShape(12.dp))
                    .padding(8.dp)
            )
        }
    }
}
