SELECT COUNT(ID) AS FISH_COUNT,MAX(LENGTH)AS MAX_LENGTH,FISH_TYPE
FROM FISH_INFO
WHERE FISH_TYPE IN(SELECT FISH_TYPE
             FROM FISH_INFO
             WHERE CASE WHEN(LENGTH IS NULL) THEN 10
                   WHEN LENGTH<=10 THEN 10
                   ELSE LENGTH END
             GROUP BY FISH_TYPE
             HAVING AVG(LENGTH)>=33)
GROUP BY FISH_TYPE
ORDER BY FISH_TYPE


#두번째 방법
SELECT COUNT(ID) AS FISH_COUNT,MAX(LENGTH)AS MAX_LENGTH,FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING  AVG(CASE WHEN(LENGTH IS NULL) THEN 10
                   WHEN LENGTH<=10 THEN 10
                   ELSE LENGTH END)>=33
ORDER BY FISH_TYPE
