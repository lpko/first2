package spring.board.service;

import java.math.BigDecimal;
import java.util.List;
import spring.board.dto.boardDto;

public interface MainService {
 
 //�Խ��� �󼼺���
 public boardDto getBoard(BigDecimal b_no) throws Exception;
 
 //�Խ��� ����Ʈ
 public List<boardDto> getBoardList(boardDto BoardDto) throws Exception;
 
 //�Է�
 public int insertBoard(boardDto BoardDto) throws Exception;
 
 //����
 public void updateBoard(boardDto BoardDto)  throws Exception;
 
 //����
 public int insertReplyBoard(boardDto BoardDto) throws Exception;
}

