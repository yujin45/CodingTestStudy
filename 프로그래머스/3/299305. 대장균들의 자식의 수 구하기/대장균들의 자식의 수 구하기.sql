SELECT E.ID, (
    SELECT COUNT(*)
    FROM ECOLI_DATA C
    WHERE C.PARENT_ID = E.ID 
) AS CHILD_COUNT
FROM ECOLI_DATA E
ORDER BY E.ID;