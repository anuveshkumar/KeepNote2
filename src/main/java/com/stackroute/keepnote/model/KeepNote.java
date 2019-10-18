package com.stackroute.keepnote.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
 * The class "Note" will be acting as the data model for the Note data in the ArrayList.
 */
//@Component
@Entity
@Table(name = "keepNotes")
public class KeepNote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "note_id")
	private int noteId;

	@Column(name = "note_title")
	private String noteTitle;

	@Column(name = "note_content")
	private String noteContent;

	@Column(name = "note_status")
	private String noteStatus;

	@Column(name = "creation_date")
	private LocalDateTime createdAt;

	public KeepNote() {
	}

    public KeepNote(String noteTitle, String noteContent, String noteStatus) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.noteStatus = noteStatus;
        this.createdAt = LocalDateTime.now();
    }

    /* All the getters/setters definition should be implemented here */

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public String getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(String noteStatus) {
		this.noteStatus = noteStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/* Override the toString() method */

	@Override
	public String toString() {
		return "Note{" +
				"noteId=" + noteId +
				", noteTitle='" + noteTitle + '\'' +
				", noteContent='" + noteContent + '\'' +
				", noteStatus='" + noteStatus + '\'' +
				", createdAt=" + createdAt +
				'}';
	}
}