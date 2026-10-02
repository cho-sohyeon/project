-- 참고용 DDL: 애플리케이션이 자동 실행하지 않습니다. 필요 시 수동으로 Oracle에 적용하세요.
CREATE TABLE exercise_log (
    id                NUMBER PRIMARY KEY,
    exercise_name     VARCHAR2(100) NOT NULL,
    exercise_date     DATE NOT NULL,
    duration_minutes  NUMBER,
    weight            NUMBER NOT NULL,
    reps              NUMBER NOT NULL,
    sets              NUMBER NOT NULL,
    created_at        TIMESTAMP DEFAULT SYSTIMESTAMP
);

CREATE SEQUENCE exercise_log_seq START WITH 1 INCREMENT BY 1 NOCACHE;
