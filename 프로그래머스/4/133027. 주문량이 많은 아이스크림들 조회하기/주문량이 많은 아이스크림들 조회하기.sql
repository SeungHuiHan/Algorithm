select c.FLAVOR
from (select a.FLAVOR, sum(a.TOTAL_ORDER)+sum(b.TOTAL_ORDER) as 'total'
      from FIRST_HALF a left join JULY b
      on a.FLAVOR= b.FLAVOR
      group by a.FLAVOR
     ) c
order by total desc
limit 3;