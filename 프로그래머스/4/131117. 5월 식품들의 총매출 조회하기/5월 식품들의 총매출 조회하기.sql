-- 코드를 입력하세요
SELECT p.PRODUCT_ID,p.PRODUCT_NAME, sum(p.price *o.amount) as TOTAL_SALES
from FOOD_PRODUCT p join FOOD_ORDER o on p.PRODUCT_ID = o.PRODUCT_ID
where o.PRODUCE_DATE like '2022-05-%'
group by product_ID
order by TOTAL_SALES desc, PRODUCT_ID asc