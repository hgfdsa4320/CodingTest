-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum(price*SALES_AMOUNT) as SALES
from product p 
join OFFLINE_SALE o on p.product_id = o.product_id
group by PRODUCT_CODE
order by sum(price*SALES_AMOUNT) desc, product_code