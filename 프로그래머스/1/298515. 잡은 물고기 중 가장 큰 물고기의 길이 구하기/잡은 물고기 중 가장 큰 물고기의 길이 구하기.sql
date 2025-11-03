-- 코드를 작성해주세요
select CONCAT(LENGTH,'cm') AS MAX_LENGTH
from FISH_INFO
order by LENGTH desc
LIMIT 1;