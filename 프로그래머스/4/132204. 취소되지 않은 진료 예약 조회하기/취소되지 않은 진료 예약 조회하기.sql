SELECT 
    A.APNT_NO,
    P.PT_NAME,
    P.PT_NO,
    A.MCDP_CD,
    D.DR_NAME,
    A.APNT_YMD
FROM 
    APPOINTMENT A
JOIN 
    PATIENT P ON A.PT_NO = P.PT_NO
JOIN 
    DOCTOR D ON A.MDDR_ID = D.DR_ID
WHERE 
    A.APNT_YMD LIKE '2022-04-13%'         -- 2022년 4월 13일
    AND A.MCDP_CD = 'CS'                  -- 흉부외과
    AND A.APNT_CNCL_YN = 'N'              -- 취소되지 않은
ORDER BY 
    A.APNT_YMD ASC;
