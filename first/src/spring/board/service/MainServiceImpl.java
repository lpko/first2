package spring.board.service;

import java.util.List;
import java.util.Map;
import java.math.BigDecimal;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.board.dto.boardDto;
import spring.board.dao.MainDao;

@Service
public class MainServiceImpl implements MainService {
	private static Logger logger = Logger.getLogger(MainServiceImpl.class);

	
	@Autowired
	private MainDao mainDao;
	

	//�Խ��� �󼼺���
	 @Override
	 @Transactional(readOnly=true)
	 public boardDto getBoard(BigDecimal b_no) throws Exception {
	  return this.mainDao.getBoard(b_no);
	 }
	 
	 //�Խ��� ����Ʈ
	 @Override
	 @Transactional(readOnly=true) 
	 public List<boardDto> getBoardList(boardDto BoardDto) throws Exception {
	  return this.mainDao.getBoardList(BoardDto);
	 }
	 
	 //�Է�
	 @Override
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	 public int insertBoard(boardDto BoardDto) throws Exception {
	  int newref = this.mainDao.getRefMax();
	  BoardDto.setRef(new BigDecimal(newref));
	  return this.mainDao.insertBoard(BoardDto);
	 }
	 
	 //����
	 @Override
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class}) 
	 public void updateBoard(boardDto BoardDto)  throws Exception {
	  this.mainDao.updateBoard(BoardDto);
	 }
	 
	 //����
	 @Override
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})  
	 public int insertReplyBoard(boardDto BoardDto) throws Exception {
	  //����(step)�� �� �����Ѵ�
	  //���� ref(�ֻ����θ�)�� ���� �� �� ���� ����� �� �Խù��� �������� ū���� +1�� �ϸ� �ϳ��� �и��� �Ѵ�.
	  this.mainDao.updateCommunitySetp(BoardDto);
	  
	  //���� ����� ������ �����ϰ� �𵨿� �����Ѵ�.
	  int netstep = this.mainDao.getStepMax(BoardDto);  
	  BoardDto.setStep(new BigDecimal(netstep));
	  
	  //��� ����
	  return this.mainDao.insertReplyBoard(BoardDto);
	 } 




}
