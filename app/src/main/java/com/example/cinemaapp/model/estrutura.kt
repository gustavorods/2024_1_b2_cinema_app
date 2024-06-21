package com.example.cinemaapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class estrutura(
    @StringRes val nome: Int,
    @StringRes val descricao: Int,
    @DrawableRes val poster: Int
)
