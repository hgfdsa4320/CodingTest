-- 코드를 작성해주세요
select Year(Ym) as year, round(avg(PM_VAL1),2) as PM10, round(avg(PM_VAL2),2) as 'PM2.5'
from AIR_POLLUTION
where Location2 = '수원'
group by Year(YM)
order by year(YM)