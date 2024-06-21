package com.example.cinemaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemaapp.ui.theme.CinemaAppTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.cinemaapp.data.dados
import com.example.cinemaapp.model.estrutura


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    cardGrid()
                }
            }
        }
    }
}

@Composable
fun header(modifier: Modifier = Modifier) {
    Box(
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFF212121)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically  // Centralize verticalmente os itens na Row
        ) {
            Image(
                painter = painterResource(R.drawable.menuicon),
                contentDescription = "Menu Icon",
                modifier = Modifier
                    .padding(5.dp)
            )
            Text(
                text = "CineSync",
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color.White, fontSize = 20.sp),
                modifier = Modifier
                    .padding(5.dp)
            )
            Image(
                painter = painterResource (R.drawable.searchicon),
                contentDescription = "Search Icon",
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}

@Composable
fun card(estrutura: estrutura, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
            .background(Color(0xFF191919), RoundedCornerShape(15.dp))
            .width(130.dp)
            .height(210.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(painter = painterResource(id = estrutura.poster),
                contentDescription = stringResource(id = estrutura.nome),
                modifier = Modifier
                    .size(120.dp)
            )
            Text(text = stringResource(id = estrutura.nome),
                 style = TextStyle(color = Color.White, fontSize = 15.sp))
            Spacer(modifier = Modifier.height(5.dp))
            Box(modifier = Modifier
                .background(Color(0xFFDCB349), RoundedCornerShape(7.dp))
                .padding(2.dp)
                .width(110.dp),
                contentAlignment = Alignment.Center
            )
            {
                Text(text = stringResource(id = estrutura.descricao))
            }
        }
}

@Composable
fun cardGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = Modifier,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp), // Espaço vertical entre os items
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        items(dados.dados) {x ->
            card(x)
        }
    }
}


@Preview
@Composable
fun previa() {
    Surface(
        modifier = Modifier.fillMaxSize()
        .statusBarsPadding(),
        color = Color(0xff323232)
    ) {
//        card(estrutura = estrutura(R.string.nomeFilme1, R.string.desc1, R.drawable.dunaposter))
        cardGrid()
    }
}