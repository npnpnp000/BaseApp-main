package com.appa.model.ui_models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MessageUiModel(val message: String, val id: Int = 0) : Parcelable

