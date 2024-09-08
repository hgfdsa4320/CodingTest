-- 코드를 입력하세요
SELECT f.FLAVOR
From FIRST_HALF f join ICECREAM_INFO i on f.flavor = i.flavor
where i.INGREDIENT_TYPE = 'fruit_based' and f.TOTAL_ORDER>3000
Order by TOTAL_ORDER desc