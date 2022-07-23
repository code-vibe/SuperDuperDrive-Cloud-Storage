package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;

public class NoteService {
    public final NoteMapper noteMapper;
    public final UserMapper userMapper;

    public NoteService(NoteMapper noteMapper, UserMapper userMapper) {
        this.noteMapper = noteMapper;
        this.userMapper = userMapper;
    }

    public void createNote(String noteTitle, String description, String username) {
        Integer userId = userMapper.getUser(username).getUserId();
        Note note = new Note(0, noteTitle,description,userId);
        noteMapper.insert(note);
    }

    public Note[] getNote(Integer userId) {
        return noteMapper.getNote(userId);
    }

    public Note getNoteById(Integer noteId) {
        return noteMapper.getNoteById(noteId);
    }

    public void updateNote(Integer noteId, String title, String description) {
         noteMapper.updateNote(noteId, title, description);
    }
    public void deleteNote(Integer noteId) {
        noteMapper.deleteNote(noteId);
    }
}
