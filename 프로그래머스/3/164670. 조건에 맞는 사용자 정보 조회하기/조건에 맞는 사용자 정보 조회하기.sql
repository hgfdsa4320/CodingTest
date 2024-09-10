-- 코드를 입력하세요
SELECT USER_ID,NICKNAME,concat(city,' ',STREET_ADDRESS1,' ',STREET_ADDRESS2) as 전체주소,concat(substr(TLNO,1,3),'-',substr(TLNO,4,4),'-',substr(TLNO,8)) as 전화번호
from USED_GOODS_BOARD b join USED_GOODS_USER u on b.WRITER_ID = u.user_id
group by WRITER_ID
having count(WRITER_ID) >= 3
order by USER_ID desc