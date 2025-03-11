-- 코드를 입력하세요
SELECT NAME, count(name) AS count
FROM ANIMAL_INS
GROUP BY NAME
HAVING count(NAME) >= 2 -- WHERE 절에 집계함수 사용 불가
ORDER BY NAME;