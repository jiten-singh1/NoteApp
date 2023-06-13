package com.jit.noteapp.feature_note.domain.use_case

import com.jit.noteapp.feature_note.domain.model.InvalidNoteException
import com.jit.noteapp.feature_note.domain.model.Note
import com.jit.noteapp.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Title of note is empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Content of note is empty")
        }
        repository.insertNote(note)
    }
}