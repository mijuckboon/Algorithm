-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(ANIMAL_TYPE) AS count -- null 존재할 수 있음에 유의! count(*) 사용 불가
FROM ANIMAL_INS
WHERE ANIMAL_TYPE IN ('Cat', 'Dog') -- Oracle에서는 큰따옴표 사용 불가. 컬럼명 등에만 사용. 문자열에서 대소문자 구별
-- MySQL은 대소문자 구별하지 않으므로 BINARY 사용 (문자가 아닌 숫자로 비교)
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE ASC;