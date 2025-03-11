-- 코드를 입력하세요
SELECT A.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR A INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B
ON A.CAR_ID = B.CAR_ID
WHERE A.CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE TO_CHAR(START_DATE,'MM') = '10')
AND A.CAR_TYPE = '세단'
GROUP BY A.CAR_ID
ORDER BY A.CAR_ID DESC;