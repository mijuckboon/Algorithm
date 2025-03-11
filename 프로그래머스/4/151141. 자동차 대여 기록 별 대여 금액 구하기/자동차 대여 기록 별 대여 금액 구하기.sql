-- 코드를 입력하세요
SELECT RH.HISTORY_ID,
(RH.END_DATE - RH.START_DATE +1)*CC.DAILY_FEE*(1-
NVL((SELECT DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN DP WHERE CC.CAR_TYPE = DP.CAR_TYPE AND DP.DURATION_TYPE = (CASE WHEN RH.END_DATE - RH.START_DATE +1 >= 90                                              THEN '90일 이상'
                                         WHEN RH.END_DATE - RH.START_DATE +1 >= 30                                              THEN '30일 이상'
                                         WHEN RH.END_DATE - RH.START_DATE +1 >= 7
                                         THEN '7일 이상' END) -- 아무것도 해당하지 않으면 NULL -> NVL에 의해 0이 됨
),0)/100) AS FEE
FROM CAR_RENTAL_COMPANY_CAR CC INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY RH
ON CC.CAR_ID = RH.CAR_ID
WHERE CC.CAR_TYPE = '트럭'
ORDER BY FEE DESC, HISTORY_ID DESC;