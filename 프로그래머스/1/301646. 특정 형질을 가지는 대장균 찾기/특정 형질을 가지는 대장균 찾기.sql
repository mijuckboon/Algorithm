-- 코드를 작성해주세요
SELECT COUNT(*) AS "COUNT"
FROM ECOLI_DATA
WHERE GENOTYPE % 8 IN (1,4,5);