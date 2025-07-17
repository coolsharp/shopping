package com.coolsharp.shopping

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coolsharp.shopping.ui.Calculator
import com.coolsharp.shopping.ui.CalculatorActions
import com.coolsharp.shopping.ui.FutureModel
import com.coolsharp.shopping.ui.HourlyModel
import com.coolsharp.shopping.ui.ProfileScreen
import com.coolsharp.shopping.ui.WeatherScreen
import com.coolsharp.shopping.viewmodel.CalculatorViewModel
import com.coolsharp.shopping.ui.theme.ShoppingTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun login(modifier: Modifier = Modifier) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .paint(
                    painterResource(R.drawable.background_page),
                    contentScale = ContentScale.FillWidth
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintLayout(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                val (topText, culm) = createRefs()
                Text(
                    text = "Login Activity",
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 16.dp, start = 32.dp)
                        .constrainAs(topText) {
                            linkTo(parent.top, culm.top, bias = 0.6f)
                            linkTo(parent.start, parent.end, bias = 0f)
                        },
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Column(
                    Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .constrainAs(culm) {
                            bottom.linkTo(parent.bottom)
                        }
                        .background(
                            color = Color(0xffe0e0e0),
                            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                        )
                        .padding(32.dp)) {
                    Text(
                        text = "Email",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 16.dp),
                        color = Color.Black
                    )
                    var text by rememberSaveable {
                        mutableStateOf("")
                    }

                    TextField(
                        text,
                        {
                            text = it
                        },
                        label = { Text(text = "coolsharp@gmail.com") },
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            focusedTextColor = Color(0xFF5e5e5e)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .background(Color.White, CircleShape)
                    )

                    Text(
                        text = "Password",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 16.dp),
                        color = Color.Black
                    )
                    var text2 by rememberSaveable {
                        mutableStateOf("")
                    }

                    TextField(
                        text,
                        {
                            text = it
                        },
                        label = { Text(text = "Type your Password") },
                        shape = RoundedCornerShape(10.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            focusedTextColor = Color(0xFF5e5e5e)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .background(Color.White, CircleShape)
                    )
                    Text(
                        "Forget Your Password? Recovery it", fontSize = 14.sp,
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color(0xFF5e5e5e)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .height(1.dp)
                                .weight(1f)
                                .background(color = Color(0xFF4d4d4d))
                        )
                        Text(
                            text = "Or Login With",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                            color = Color(0xFF4d4d4d)
                        )
                        Box(
                            modifier = Modifier
                                .height(1.dp)
                                .weight(1f)
                                .background(color = Color(0xFF4d4d4d))
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Button(
                            {}, Modifier
                                .padding(top = 10.dp, bottom = 10.dp, end = 8.dp)
                                .fillMaxWidth()
                                .height(55.dp),
                            border = BorderStroke(
                                1.dp,
                                Color(0xFF4d4d4d)
                            ),
                            colors = ButtonDefaults.buttonColors(
                                Color.Transparent
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(0.3f),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.google),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(25.dp)
                                        .clickable {})
                            }
                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(0.7f),
                                verticalArrangement = Arrangement.Center,
                            ) {
                                Text(text = "Google",
                                    color = Color(0xFF4e4e4e),
                                    fontSize = 20.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}