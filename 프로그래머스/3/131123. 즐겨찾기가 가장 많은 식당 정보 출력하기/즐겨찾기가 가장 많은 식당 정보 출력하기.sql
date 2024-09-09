-- 코드를 입력하세요
SELECT FOOD_TYPE,REST_ID,REST_NAME,FAVORITES
from REST_INFO
where (Food_type,favorites) in (select Food_type,max(FAVORITES)
                               from REST_INFO
                               group by Food_type)
order by FOOD_TYPE desc
