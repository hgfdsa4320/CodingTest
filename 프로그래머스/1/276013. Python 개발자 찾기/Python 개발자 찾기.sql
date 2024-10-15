-- 코드를 작성해주세요
select ID,EMAIL,FIRST_NAME,LAST_NAME
from DEVELOPER_INFOS
where SKILL_1 = 'PYTHON' or SKILL_2 = 'PYTHON' or SKILL_3 = 'PYTHON'
order by id;