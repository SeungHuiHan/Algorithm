select history_id, 
        case when days>=90 then round(days* DAILY_FEE*(100-(select DISCOUNT_RATE from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where DURATION_TYPE like '90일%' and CAR_TYPE='트럭'))/100,0)
            when days>=30 then round(days* DAILY_FEE*(100-(select DISCOUNT_RATE from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where DURATION_TYPE like '30일%'and CAR_TYPE='트럭'))/100,0)
            when days>=7 then round(days* DAILY_FEE*(100-(select DISCOUNT_RATE from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where DURATION_TYPE like '7일%'and CAR_TYPE='트럭'))/100,0)
            else round(days* DAILY_FEE,0) end as 'FEE'
from(
select a.CAR_ID, HISTORY_ID, DAILY_FEE, days
from (select * from CAR_RENTAL_COMPANY_CAR where CAR_TYPE='트럭') a,
     (select *, datediff(END_DATE,START_DATE)+1 as 'days' 
      from CAR_RENTAL_COMPANY_RENTAL_HISTORY
      ) b
where a.CAR_ID=b.CAR_ID
) c
order by fee desc, history_id desc