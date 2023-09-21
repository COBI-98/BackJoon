-- 코드를 입력하세요
SELECT FP.PRODUCT_ID,
        FP.PRODUCT_NAME,
        SUM(FP.PRICE * FO.AMOUNT) AS TOTAL_SALES 
FROM FOOD_PRODUCT FP
LEFT JOIN FOOD_ORDER FO
ON (FP.PRODUCT_ID = FO.PRODUCT_ID)
WHERE YEAR(FO.PRODUCE_DATE) = 2022 AND
MONTH(FO.PRODUCE_DATE) = 05 
GROUP BY FO.PRODUCT_ID
ORDER BY 3 DESC, 1 ASC;