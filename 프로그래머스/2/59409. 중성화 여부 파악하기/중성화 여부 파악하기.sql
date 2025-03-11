-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, CASE
WHEN SEX_UPON_INTAKE LIKE '%Neutered%'
OR SEX_UPON_INTAKE LIKE '%Spayed%'
THEN 'O' ELSE 'X' END
AS "중성화" -- '' 쓰면 FROM keyword not found where expeted 오류 발생
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;