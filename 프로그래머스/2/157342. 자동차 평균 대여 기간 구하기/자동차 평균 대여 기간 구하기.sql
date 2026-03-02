 select CAR_ID, round(avg(datediff(END_DATE,START_DATE)+1),1) as 'AVERAGE_DURATION'
 from CAR_RENTAL_COMPANY_RENTAL_HISTORY
 group by car_id
 having avg(datediff(END_DATE,START_DATE)+1)>=7
 order by round(avg(datediff(END_DATE,START_DATE)+1),1) desc, CAR_ID desc 
