package com.coolsharp.shopping.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coolsharp.shopping.R

@Preview(showBackground = true)
@Composable
fun WeatherScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF59469d), Color(0xFF643d67)
                    )
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                item {
                    Text(
                        text = "Mostly Cloudy",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 48.dp),
                        textAlign = TextAlign.Center
                    )

                    Image(
                        painter = painterResource(id = R.drawable.cloudy_sunny),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .padding(top = 8.dp)
                    )

                    // 날짜 시간 표시
                    Text(
                        text = "Mon June 17 | 10:00 AM",
                        fontSize = 19.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center
                    )

                    // 온도 표시
                    Text(
                        text = "25°",
                        fontSize = 63.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center
                    )

                    Text(
                        "H:27 L:18",
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 16.dp)
                            .background(
                                color = colorResource(R.color.purple),
                                shape = RoundedCornerShape(25.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            WeatherDetailItem(
                                icon = R.drawable.rain, value = "22%", label = "Rain"
                            )
                            WeatherDetailItem(
                                icon = R.drawable.wind, value = "12Km/h", label = "Wind Speed"
                            )
                            WeatherDetailItem(
                                icon = R.drawable.humidity, value = "28%", label = "Humidity"
                            )
                        }
                    }

                    // 오늘 라벨 표시
                    Text(
                        text = "Today",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 8.dp)
                    )
                }

                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(items) { item ->
                            FutureModelViewHolder(item)
                        }
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Future",
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "Next 7 Day",
                            fontSize = 14.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                items(dailyItems) {
                    FutureItem(it)
                }
            }
        }
    }
}

@Composable
fun FutureItem(
    item: FutureModel, modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item.day, color = Color.White, fontSize = 14.sp
        )

        Image(
            painter = painterResource(id = getDrawableResourceId(item.picPath)),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 32.dp)
                .size(45.dp)
        )

        Text(
            text = item.status,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            color = Color.White,
            fontSize = 14.sp
        )

        Text(
            text = "${item.highTemp}°",
            modifier = Modifier.padding(end = 16.dp),
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Composable
fun getDrawableResourceId(picPath: String, modifier: Modifier = Modifier): Int {
    return when (picPath) {
        "cloudy" -> R.drawable.cloudy
        "sunny" -> R.drawable.sunny
        "wind" -> R.drawable.wind
        "cloudy_sunny" -> R.drawable.cloudy_sunny
        "rainy" -> R.drawable.rainy
        "stom" -> R.drawable.storm
        else -> R.drawable.sunny
    }
}

val dailyItems = listOf(
    FutureModel("Sat", "storm", "Storm", 24, 12),
    FutureModel("Sun", "cloudy", "Cloudy", 25, 16),
    FutureModel("Mon", "windy", "Windy", 29, 15),
    FutureModel("Tue", "cloudy_sunny", "Cloudy Sunny", 23, 15),
    FutureModel("Wen", "sunny", "Sunny", 28, 11),
    FutureModel("Thu", "rainy", "Rainy", 23, 12),
)

@Composable
fun FutureModelViewHolder(
    model: HourlyModel, modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .width(90.dp)
            .wrapContentHeight()
            .padding(4.dp)
            .background(
                color = colorResource(R.color.purple), shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = model.hour,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(
                id = when (model.picPath) {
                    "cloudy" -> R.drawable.cloudy
                    "sunny" -> R.drawable.sunny
                    "wind" -> R.drawable.wind
                    "rainy" -> R.drawable.rainy
                    "stom" -> R.drawable.storm
                    else -> R.drawable.sunny
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "${model.temp}",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center
        )
    }
}

val items = listOf(
    HourlyModel(hour = "9 pm", temp = 28, picPath = "cloudy"),
    HourlyModel(hour = "10 pm", temp = 29, picPath = "sunny"),
    HourlyModel(hour = "11 pm", temp = 30, picPath = "wind"),
    HourlyModel(hour = "12 pm", temp = 31, picPath = "rainy"),
    HourlyModel(hour = "1 am", temp = 28, picPath = "stom"),
)

@Composable
fun WeatherDetailItem(
    icon: Int, value: String, label: String, modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(34.dp)
        )
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.white),
            textAlign = TextAlign.Center
        )
        Text(
            text = label, color = colorResource(R.color.white), textAlign = TextAlign.Center
        )
    }
}