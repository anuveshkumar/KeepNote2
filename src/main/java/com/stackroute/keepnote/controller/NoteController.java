package com.stackroute.keepnote.controller;


import com.stackroute.keepnote.dao.NoteDAO;
import com.stackroute.keepnote.model.KeepNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
	    model.addAttribute("notes", keepNotes);
		for (KeepNote keepNote : keepNotes){
			System.out.println(keepNote);
		}
		System.out.println();
	    return "index";
    }

	@PostMapping("/saveNote")
	public String save(HttpServletRequest httpServletRequest){
		int Id = Integer.parseInt(httpServletRequest.getParameter("noteId"));
		String title = httpServletRequest.getParameter("noteTitle");
		String content = httpServletRequest.getParameter("noteContent");
		String status = httpServletRequest.getParameter("noteStatus");
		KeepNote keepNote = new KeepNote(title, content, status);
		noteDAO.saveNote(keepNote);
		return "redirect:/";
	}

	@GetMapping("/deleteNote")
	public String deleteNote(@RequestParam("noteId") int noteId) throws Exception {
		System.out.println(noteId);
		noteDAO.deleteNote(noteId);
		return "redirect:/";
	}
}