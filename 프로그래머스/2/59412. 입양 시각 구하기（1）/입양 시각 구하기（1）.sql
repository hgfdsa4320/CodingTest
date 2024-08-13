SELECT Hour, COUNT(Hour)
FROM (
    SELECT date_format(datetime,'%H') as Hour 
    FROM ANIMAL_OUTS
) H
where Hour between 9 and 19
GROUP BY Hour
order by hour