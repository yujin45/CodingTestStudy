WITH FRONT AS(
    SELECT SUM(CODE) AS FRONT_CODE
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
)

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE SKILL_CODE & (SELECT FRONT_CODE FROM FRONT) > 0 
ORDER BY ID ASC;