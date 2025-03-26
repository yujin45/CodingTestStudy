SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2) = 0  -- 2번 형질을 포함하지 않는 경우
AND ((GENOTYPE & 1) != 0 OR (GENOTYPE & 4) != 0); -- 1번 또는 3번 형질을 포함하는 경우
