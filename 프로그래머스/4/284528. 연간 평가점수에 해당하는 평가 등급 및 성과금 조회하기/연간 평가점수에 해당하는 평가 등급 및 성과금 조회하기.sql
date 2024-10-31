-- 코드를 작성해주세요
select e.EMP_NO,e.EMP_NAME,(case 
                            when AVG(SCORE)>=96 then 'S'
                            when AVG(SCORE)>=90 then 'A'
                            when AVG(SCORE)>=80 then 'B'
                            else 'C' end) as GRADE,
                            (case
                            when AVG(SCORE)>=96 then e.SAL*0.2
                            when AVG(SCORE)>=90 then e.SAL*0.15
                            when AVG(SCORE)>=80 then e.SAL*0.1
                            else 0 end) as BONUS
from HR_EMPLOYEES e
join HR_GRADE g
on e.EMP_NO = g.EMP_NO
group by g.EMP_NO
order by e.EMP_NO