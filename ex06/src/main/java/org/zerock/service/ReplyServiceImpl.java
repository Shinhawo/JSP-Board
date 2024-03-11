package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVo;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVo vo) {
		
		log.info("register........" + vo);
		
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		
		return mapper.insert(vo);
	}
	
	@Override
	public ReplyVo get(Long rno) {
		log.info("get........" + rno);
		return mapper.read(rno);
	}
	
	@Override
	public List<ReplyVo> getList(Criteria cri, Long bno) {
		log.info("get Reply List of a Board........" + bno);
		return mapper.getListWithPaging(cri, bno);
	}
	
	@Override
	public int modify(ReplyVo vo) {
		log.info("modify........" + vo);
		return mapper.update(vo);
	}
	
	@Override
	public int remove(Long rno) {
		
		log.info("remove........" + rno);
		
		ReplyVo vo = mapper.read(rno);
		
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		
		return mapper.delete(rno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {

		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}
}
