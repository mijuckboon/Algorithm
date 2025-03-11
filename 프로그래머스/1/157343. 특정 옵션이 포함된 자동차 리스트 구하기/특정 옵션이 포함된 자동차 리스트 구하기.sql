-- 코드를 입력하세요
SELECT * from car_rental_company_car
where regexp_substr(options,'네비게이션') = '네비게이션'
order by 1 desc;