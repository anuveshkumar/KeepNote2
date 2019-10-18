package com.stackroute.keepnote.dao;

import com.stackroute.keepnote.model.KeepNote;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class NoteDAOImpl implements NoteDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean saveNote(KeepNote keepNote) {
        if(keepNote != null) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.saveOrUpdate(keepNote);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteNote(int noteId) throws Exception {
        Session currentSession = sessionFactory.getCurrentSession();
        KeepNote keepNote = getNoteById(noteId);
        if(keepNote != null) {
            currentSession.delete(keepNote);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public List<KeepNote> getAllNotes() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<KeepNote> query = currentSession.createQuery("from KeepNote order by creation_date", KeepNote.class);
        List<KeepNote> keepNotes = query.getResultList();
        return keepNotes;
    }

    @Override
    @Transactional
    public KeepNote getNoteById(int noteId) throws Exception {
        Session currentSession = sessionFactory.getCurrentSession();
        KeepNote keepNote = currentSession.get(KeepNote.class, noteId);
        if(keepNote == null){
            throw new Exception("No note found with id : " + noteId);
        }
        return keepNote;
    }

    @Override
    @Transactional
    public boolean UpdateNote(KeepNote keepNote) {
        if(keepNote != null){
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.update(keepNote);
            return true;
        }
        return false;
    }
}
