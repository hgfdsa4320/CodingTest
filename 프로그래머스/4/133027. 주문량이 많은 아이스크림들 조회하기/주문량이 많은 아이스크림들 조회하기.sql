-- 코드를 입력하세요
SELECT f.FLAVOR
from FIRST_HALF f
join (select FLAVOR,sum(TOTAL_ORDER) as total_order
      from JULY
      group by FLAVOR) j
on f.FLAVOR = j.FLAVOR
order by f.TOTAL_ORDER+j.total_order desc
limit 3
      