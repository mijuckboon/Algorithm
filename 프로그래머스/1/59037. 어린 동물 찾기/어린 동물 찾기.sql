-- 코드를 입력하세요
SELECT animal_id, name --, (select count(*) from animal_ins where intake_condition <> 'Aged')
from animal_ins
where intake_condition <> 'Aged'
order by animal_id;