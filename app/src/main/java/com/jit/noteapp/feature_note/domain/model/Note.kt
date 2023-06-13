package com.jit.noteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jit.noteapp.ui.theme.LightGreen
import com.jit.noteapp.ui.theme.LightLime
import com.jit.noteapp.ui.theme.RedOrange
import com.jit.noteapp.ui.theme.SeaGreen
import com.jit.noteapp.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey
    val id: Int? = null,
) {
    companion object {
        val noteColorsList = listOf(RedOrange, LightGreen, Violet, SeaGreen, LightLime)
    }
}

class InvalidNoteException(message :String):Exception(message)
