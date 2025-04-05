WITH SKILLS AS (
    SELECT 
        NAME, CATEGORY, CODE
    FROM SKILLCODES
),
FRONT AS (
    SELECT CODE FROM SKILLS WHERE CATEGORY = 'Front End'
),
DEVS AS (
    SELECT 
        D.ID, D.EMAIL, D.SKILL_CODE,
        -- Front End 스킬 여부
        EXISTS (
            SELECT 1 FROM FRONT 
            WHERE D.SKILL_CODE & FRONT.CODE > 0
        ) AS HAS_FRONT,
        -- Python 스킬 여부
        D.SKILL_CODE & (SELECT CODE FROM SKILLS WHERE NAME = 'Python') > 0 AS HAS_PYTHON,
        -- C# 스킬 여부
        D.SKILL_CODE & (SELECT CODE FROM SKILLS WHERE NAME = 'C#') > 0 AS HAS_CSHARP
    FROM DEVELOPERS D
),
GRADED AS (
    SELECT 
        ID, EMAIL,
        CASE
            WHEN HAS_FRONT = 1 AND HAS_PYTHON = 1 THEN 'A'
            WHEN HAS_CSHARP = 1 THEN 'B'
            WHEN HAS_FRONT = 1 THEN 'C'
        END AS GRADE
    FROM DEVS
)
SELECT 
    GRADE, ID, EMAIL
FROM GRADED
WHERE GRADE IS NOT NULL
ORDER BY GRADE, ID;
