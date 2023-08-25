package com.rfomin.todo.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rfomin.todo.database.entity.Task

@Composable
fun TaskList(
    items: List<Task>,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
            .border(BorderStroke(1.dp, Color.Black))
    ) {
        Column {
            ListHeader()

            val state = rememberLazyListState()
            val itemCount = items.size

            LazyColumn(Modifier.fillMaxSize(), state) {
                items(itemCount) { index ->
                    val item = items[index]
                    TaskRow(
                        title = item.title,
                        background = if (index.mod(2) == 0) {
                            Color.Transparent
                        } else {
                            Color(230, 230, 230)
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier
            .width(1.dp)
            .fillMaxHeight()
            .background(color = Color.Black)
            .align(Alignment.Center)
        )
    }
}

@Composable
fun ListHeader() {
    Row(
        modifier = Modifier
            .background(Color(200, 200, 200))
            .height(32.dp)
    ) {
        Text(
            text = "Task Title",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = "Actions",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
    }
}


@Composable
fun TaskRow(
    title: String,
    background: Color = Color.Transparent,
) {
    Row(
        modifier = Modifier
            .background(background)
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp)
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(20.dp)
                .align(Alignment.CenterVertically)
        ) {

        }
    }
}