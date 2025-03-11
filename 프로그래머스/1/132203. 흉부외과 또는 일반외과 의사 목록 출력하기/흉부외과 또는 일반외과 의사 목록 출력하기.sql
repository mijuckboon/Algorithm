-- 코드를 입력하세요
SELECT dr_name, dr_id, mcdp_cd, to_char(hire_ymd, 'YYYY-MM-DD') as hire_ymd
from doctor
where regexp_like(mcdp_cd, '(C|G)S')
order by hire_ymd desc, dr_name;