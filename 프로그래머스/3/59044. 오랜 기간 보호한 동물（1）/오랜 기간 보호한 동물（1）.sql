-- 코드를 입력하세요
SELECT i.NAME,i.DATETIME
from ANIMAL_INS i left outer join ANIMAL_OUTS o on i.animal_id = o.animal_id
where o.animal_id is null
order by DATETIME
limit 3
