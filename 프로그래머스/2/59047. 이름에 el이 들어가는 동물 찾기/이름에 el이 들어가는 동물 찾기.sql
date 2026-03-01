select ANIMAL_ID, name
from ANIMAL_INS
where ANIMAL_TYPE='Dog' and NAME like '%el%'
order by name