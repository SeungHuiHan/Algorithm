SELECT SUM(SCORE)AS SCORE,C.EMP_NO,EMP_NAME,POSITION,EMAIL
FROM  HR_EMPLOYEES AS B JOIN HR_GRADE AS C ON B.EMP_NO=C.EMP_NO
WHERE YEAR=2022
GROUP BY C.EMP_NO,EMP_NAME,POSITION,EMAIL
ORDER BY SCORE DESC
LIMIT 1
# ORDER BY