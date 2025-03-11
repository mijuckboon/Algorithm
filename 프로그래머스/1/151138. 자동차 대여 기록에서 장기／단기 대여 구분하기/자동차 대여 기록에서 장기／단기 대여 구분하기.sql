-- 코드를 입력하세요
SELECT history_id, car_id, to_char(start_date, 'YYYY-MM-DD') as start_date, to_char(end_date, 'YYYY-MM-DD') as end_date, CASE WHEN (END_DATE - START_DATE) >= 29 then '장기 대여' else '단기 대여' end AS RENT_TYPE -- A.*, ~ 형태 사용하면 복사 + 칼럼 추가 가능. 조건 30이 아닌 29여야 함
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
where to_char(start_date,'YYYY-MM') = '2022-09'
ORDER BY 1 DESC;