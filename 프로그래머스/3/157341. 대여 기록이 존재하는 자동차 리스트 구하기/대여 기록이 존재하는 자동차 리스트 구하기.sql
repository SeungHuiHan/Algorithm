select distinct(b.CAR_ID)
from CAR_RENTAL_COMPANY_RENTAL_HISTORY a join CAR_RENTAL_COMPANY_CAR b
where a.CAR_ID=b.CAR_ID and CAR_TYPE='세단'and  date_format(START_DATE,'%m')='10'
order by CAR_ID desc