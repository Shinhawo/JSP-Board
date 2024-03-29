package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardAttachVo;
import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;

public interface BoardService {

	public void register(BoardVo board);
	
	public BoardVo get(Long bno);
	
	public boolean modify(BoardVo board);
	
	public boolean remove(Long bno);
	
	//public List<BoardVo> getList();
	
	public List<BoardVo> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
	public List<BoardAttachVo> getAttachList(Long bno);
	
}
