package spring.board.dao;

import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import spring.board.dto.boardDto;


public interface MainDao  {
	//�Խ��� �󼼺���
	 public boardDto getBoard(BigDecimal b_no) throws Exception;
	 
	 //�Խ��� ����Ʈ
	 public List<boardDto> getBoardList(boardDto BoardDto) throws Exception;
	 
	 //�Է�
	 public int insertBoard(boardDto BoardDto) throws Exception;
	 
	 //����
	 public void updateBoard(boardDto BoardDto)  throws Exception;
	 
	 //�ֻ��� �θ�� ��ȣ����
	 public int getRefMax()  throws Exception;
	 
	 //���� ref(�ֻ����θ�)�� ���� �� �� ���� ����� �� �Խù��� �������� ū���� +1�� �ϸ� �ϳ��� �и��� �Ѵ�.
	 public void updateCommunitySetp(boardDto BoardDto)  throws Exception;
	 
	 //���� ����� ������ ���� 
	 public int  getStepMax(boardDto BoardDto)  throws Exception;
	 
	 //��������
	 public int insertReplyBoard(boardDto BoardDto) throws Exception; 
	}

	

