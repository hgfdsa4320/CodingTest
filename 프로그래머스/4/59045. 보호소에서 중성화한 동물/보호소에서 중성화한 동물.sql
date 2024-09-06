-- 코드를 입력하세요
SELECT i.ANIMAL_ID,i.ANIMAL_TYPE,i.NAME
from ANIMAL_INS i join ANIMAL_OUTS o on i.animal_id = o.animal_id
where i.SEX_UPON_INTAKE like '%intact%' and o.SEX_UPON_OUTCOME not like '%intact%'
order by i.ANIMAL_ID