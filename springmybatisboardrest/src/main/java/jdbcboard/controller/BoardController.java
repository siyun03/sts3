package jdbcboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jdbcboard.model.Board;
import jdbcboard.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/boards")
	public ModelAndView selectBoard(ModelAndView mav) {
		List<Board> boardList = boardService.selectBoard();
		mav.addObject("boardList", boardList);
		mav.setViewName("/board/listBoard");
		return mav;
	}
	
	@GetMapping("/boardsJson")
	@ResponseBody
	public List<Board> selectBoard() {
		return boardService.selectBoard();
	}	
	
	@GetMapping("/insertBoardForm")
	public String insertBoardForm() {
		return "/board/insertBoardForm";
	}
	
	@PostMapping("/boards")
	public String insertBoard(@ModelAttribute Board board) {
		boardService.insertBoard(board);
		return "redirect:/board/boards";
	}
	
	@GetMapping("/updateBoardForm/{bid}")
	public ModelAndView updateBoardForm(@PathVariable String bid) {
		ModelAndView mav = new ModelAndView();
		Board board = boardService.getBoard(Integer.parseInt(bid));
		mav.addObject(board);
		mav.setViewName("/board/updateBoardForm");
		return mav;
	}
	
	@PutMapping("/boards")
	@ResponseBody
	public Map<String, Integer> updateBoard(@RequestBody Board board) {
		int result = boardService.updateBoard(board);
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put("result", result);
		return resultMap;
	}
	
} // class















