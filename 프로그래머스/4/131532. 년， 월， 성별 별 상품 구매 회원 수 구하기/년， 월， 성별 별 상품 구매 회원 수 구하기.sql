SELECT YEAR(SALES_DATE) AS 'YEAR',MONTH(SALES_DATE)AS 'MONTH',GENDER,COUNT(DISTINCT (A.USER_ID)) AS 'USERS'
FROM USER_INFO AS A JOIN ONLINE_SALE AS B ON A.USER_ID=B.USER_ID
WHERE  GENDER IS NOT NULL
GROUP BY YEAR(SALES_DATE),MONTH(SALES_DATE),GENDER
 #HAVING
ORDER BY YEAR(SALES_DATE),MONTH(SALES_DATE),GENDER