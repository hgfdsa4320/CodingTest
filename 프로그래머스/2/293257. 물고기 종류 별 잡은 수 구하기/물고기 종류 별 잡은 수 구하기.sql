-- 코드를 작성해주세요
select count(*) as FISH_COUNT, FISH_NAME
from FISH_NAME_INFO n join FISH_INFO i on n.FISH_TYPE = i.FISH_TYPE
group by FISH_NAME
order by FISH_COUNT desc