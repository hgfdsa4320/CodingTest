-- 코드를 입력하세요
select MONTH(START_DATE) as MONTH,CAR_ID,count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in (SELECT CAR_ID
                from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                where YEAR(START_DATE) = 2022 and MONTH(START_DATE)>= 8 and MONTH(START_DATE)<=10
                group by car_id
                having count(*)>=5)
and YEAR(START_DATE) = 2022 and MONTH(START_DATE)>= 8 and MONTH(START_DATE)<=10
group by MONTH, CAR_ID
order by MONTH, CAR_ID DESC