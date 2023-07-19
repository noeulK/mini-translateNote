package egovframework.noteTranslate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note/")
public class NoteController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/writeNoteForm.do")
	public String getWriteNoteForm() {
		return "/note/noteForm";
	}
}
