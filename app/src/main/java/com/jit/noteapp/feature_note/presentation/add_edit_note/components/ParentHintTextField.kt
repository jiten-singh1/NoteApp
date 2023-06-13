package com.jit.noteapp.feature_note.presentation.add_edit_note.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.jit.noteapp.feature_note.domain.util.NoteOrder
import com.jit.noteapp.feature_note.domain.util.OrderType
import com.jit.noteapp.feature_note.presentation.notes.components.OrderSection
import com.jit.noteapp.ui.theme.NoteAppTheme

@Composable
fun ParentHintTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    onFocusChange: (FocusState) -> Unit
) {
    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    onFocusChange(it)
                }

        )
        if (isHintVisible) {
            Text(
                text = hint,
                style = textStyle,
                color = Color.DarkGray
            )
        }
    }
}


@Composable
@Preview(showBackground = true, heightDp = 100)
fun ParentHintTextFieldPreview() {
    val textStyle = MaterialTheme.typography.headlineMedium
    NoteAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ParentHintTextField(
                "Test",
                "",
                modifier = Modifier,
                false,
                onValueChange = {},
                textStyle = textStyle,
                singleLine = false,
                onFocusChange = {})
        }
    }
}