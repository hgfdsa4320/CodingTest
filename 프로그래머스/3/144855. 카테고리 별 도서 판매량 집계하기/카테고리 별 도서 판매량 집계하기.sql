-- 코드를 입력하세요
SELECT b.category, sum(sales) as total_sales
from Book b
join BOOK_SALES s on b.book_id = s.book_id
where sales_date like '2022-01%'
group by b.category
order by b.category