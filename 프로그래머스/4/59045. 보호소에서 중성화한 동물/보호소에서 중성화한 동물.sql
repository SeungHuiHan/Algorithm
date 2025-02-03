SELECT B.ANIMAL_ID,B.ANIMAL_TYPE,B.NAME
FROM ANIMAL_INS AS A JOIN ANIMAL_OUTS AS B ON A.ANIMAL_ID=B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE LIKE 'Intact%' AND B.ANIMAL_ID IN(SELECT ANIMAL_ID
                                                      FROM ANIMAL_OUTS
                                                      WHERE SEX_UPON_OUTCOME LIKE 'Spayed%' OR 
                                                          SEX_UPON_OUTCOME LIKE 'Neutered%')
