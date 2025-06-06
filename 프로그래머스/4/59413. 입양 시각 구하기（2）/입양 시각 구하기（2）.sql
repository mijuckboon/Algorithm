-- 코드를 입력하세요
SELECT FULL_HOUR, NVL(CNT,0) AS COUNT --fm
FROM 
(SELECT TO_NUMBER(TO_CHAR(DATETIME,'HH24')) AS HOUR, COUNT(*) AS CNT
FROM ANIMAL_OUTS
GROUP BY TO_NUMBER(TO_CHAR(DATETIME,'HH24'))) A RIGHT OUTER JOIN (SELECT LEVEL-1 AS FULL_HOUR FROM DUAL CONNECT BY LEVEL <= 24) B
ON HOUR = FULL_HOUR
ORDER BY FULL_HOUR;