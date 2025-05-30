-- 코드를 작성해주세요
SELECT A.ID AS ID, B.FISH_NAME, MAX(A.LENGTH) OVER(PARTITION BY FISH_NAME) AS LENGTH
FROM FISH_INFO A INNER JOIN FISH_NAME_INFO B
ON A.FISH_TYPE = B.FISH_TYPE
WHERE (A.FISH_TYPE, A.LENGTH) IN (SELECT FISH_TYPE, MAX(LENGTH) FROM FISH_INFO GROUP BY FISH_TYPE)
ORDER BY ID;