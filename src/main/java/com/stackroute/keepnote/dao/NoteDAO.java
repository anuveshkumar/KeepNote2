package com.stackroute.keepnote.dao;

import com.stackroute.keepnote.model.KeepNote;

import java.util.List;

public interface NoteDAO {

    /* You Should not modify this interface.  You have to implement these methods in corresponding Impl class*/

    public boolean saveNote(KeepNote keepNote);

    public boolean deleteNote(int noteId) throws Exception;

    public List<KeepNote> getAllNotes();

    public KeepNote getNoteById(int noteId) throws Exception;

    public boolean UpdateNote(KeepNote keepNote);

}
