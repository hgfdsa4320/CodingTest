-- 코드를 입력하세요
SELECT BOARD_ID,WRITER_ID,TITLE,PRICE, (
    case 
    when status = 'Done' then '거래완료' 
    when status = 'RESERVED' then '예약중'
    else '판매중' end) as status
from USED_GOODS_BOARD
where CREATED_DATE = '2022-10-05'
order by BOARD_ID desc