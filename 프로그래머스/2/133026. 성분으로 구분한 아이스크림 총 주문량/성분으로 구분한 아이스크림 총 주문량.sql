-- 코드를 입력하세요
SELECT INGREDIENT_TYPE,	sum(TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF f join ICECREAM_INFO i on f.flavor = i.flavor
group by i.INGREDIENT_TYPE
order by TOTAL_ORDER