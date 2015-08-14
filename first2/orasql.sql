CREATE TABLE TB_BOARD
(
    IDX NUMBER PRIMARY KEY,
    PARENT_IDX NUMBER,
    TITLE VARCHAR2(100) NOT NULL,
    CONTENTS VARCHAR2(4000) NOT NULL,
    HIT_CNT NUMBER NOT NULL,
    DEL_GB VARCHAR2(1) DEFAULT 'N' NOT NULL,
    CREA_DTM DATE DEFAULT SYSDATE NOT NULL,
    CREA_ID VARCHAR2(30) NOT NULL
);

COMMENT ON TABLE TB_BOARD IS '�Խ���';
COMMENT ON COLUMN TB_BOARD.IDX IS '�ε���';
COMMENT ON COLUMN TB_BOARD.PARENT_IDX IS '�θ�� �ε���';
COMMENT ON COLUMN TB_BOARD.TITLE IS '����';
COMMENT ON COLUMN TB_BOARD.CONTENTS IS '����';
COMMENT ON COLUMN TB_BOARD.HIT_CNT IS '��ȸ��';
COMMENT ON COLUMN TB_BOARD.DEL_GB IS '��������';
COMMENT ON COLUMN TB_BOARD.CREA_DTM IS '��������';
COMMENT ON COLUMN TB_BOARD.CREA_ID IS '������ ID';



������ ����
CREATE SEQUENCE SEQ_TB_BOARD_IDX
START WITH 1
INCREMENT BY 1
NOMAXVALUE
NOCACHE;


������ ��ȸ
select * from user_sequences
where sequence_name = 'SEQ_TB_BOARD_IDX'
;

������ �ʱ�ȭ
select SEQ_TB_BOARD_IDX.nextval from dual; 
alter sequence SEQ_TB_BOARD_IDX increment by -2 minvalue 0;
select SEQ_TB_BOARD_IDX.nextval from dual;
alter sequence SEQ_TB_BOARD_IDX increment by 1 minvalue 0;


�Խ��� ��ȸ
SELECT
    IDX,
    TITLE,
    HIT_CNT,
    CREA_DTM
FROM
    TB_BOARD
ORDER BY IDX DESC

idx ����
update TB_BOARD
set IDX = 1;

�Խ��� boardlist �׽�Ʈ��
INSERT INTO TB_BOARD
(
    IDX,
    TITLE, 
    CONTENTS, 
    HIT_CNT, 
    DEL_GB, 
    CREA_DTM, 
    CREA_ID
)
VALUES
(
    SEQ_TB_BOARD_IDX.nextval, 
    '����1', 
    '����1', 
    0, 
    'N', 
    SYSDATE, 
    'Admin'
);