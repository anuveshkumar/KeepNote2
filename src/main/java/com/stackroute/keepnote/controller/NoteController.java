package com.stackroute.keepnote.controller;


import com.stackroute.keepnote.dao.NoteDAO;
import com.stackroute.keepnote.model.KeepNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/*Annotate the class with @Controller annotation. @Controller annotation is used to mark
 * any POJO class as a controller so that Spring can recognize this class as a Controller
 * */
@Controller
public class NoteController {

    private NoteDAO noteDAO;

    @Autowired
	public NoteController(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}

	@RequestMapping("/")
    public String getAllNotes(Model model){
	    List<KeepNote> keepNotes = noteDAO.getAllNotes();
	    KeepNote note = new KeepNote();
		model.addAttribute("keepNote", note);			// model attribute for the form
	    model.addAttribute("notes", keepNotes);			// model attribute for the list
		for (KeepNote keepNote : keepNotes){
			System.out.println(keepNote);
		}
		System.out.println();
	    return "index";
    }
	// why the time wouldn't come.. the form now has a layer of an instance of keep note, and I need to know
	// the time when the user clicks on the save button
	@PostMapping("/saveNote")
	public String save(@ModelAttribute("keepNote") KeepNote note){
		note.setCreatedAt(LocalDateTime.now());
		noteDAO.saveNote(note);
		return "redirect:/";
	}

	@GetMapping("/deleteNote")
	public String deleteNote(@RequestParam("noteId") int noteId) throws Exception {
		System.out.println(noteId);
		noteDAO.deleteNote(noteId);
		return "redirect:/";
	}

	@GetMapping("/updateNote")
	public String updateForm(@RequestParam("noteId") int noteId, Model model) throws Exception {
    	KeepNote note = noteDAO.getNoteById(noteId);
    	model.addAttribute("keepNote", note);
    	return "update";
	}

	@PostMapping("/saveUpdatedNote")
	public String saveUpdatedNote(@ModelAttribute("keepNote") KeepNote note){
		noteDAO.saveNote(note);
		return "redirect:/";
	}

}