-- 참고용 DDL: 애플리케이션이 자동 실행하지 않습니다. 필요 시 수동으로 Oracle에 적용하세요.
CREATE TABLE exercise_log (
    id                NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    exercise_name     VARCHAR2(100) NOT NULL,
    exercise_date     DATE NOT NULL,
    duration_minutes  NUMBER,
    created_at        TIMESTAMP DEFAULT SYSTIMESTAMP
);
