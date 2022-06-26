CREATE TABLE IF NOT EXISTS employees
(
    id bigserial primary key
    ,first_name  VARCHAR(45) NOT NULL
    ,last_name VARCHAR(45) NOT NULL
    ,patronymic VARCHAR(45)  NOT NULL
    ,job_position VARCHAR(45)  NOT NULL
);

CREATE TABLE IF NOT EXISTS safety_training_programs
(
    id bigserial primary key
    ,title_of_program  VARCHAR(45) NOT NULL
    ,program_number Integer NOT NULL
    ,duration Integer NOT NULL
    ,approved_the_program VARCHAR(45) NOT NULL
    ,date_of_approval DATE NOT NULL
--     ,certification_id BIGINT references certifications (id)
--     ,UNIQUE (certification_id)
);

CREATE TABLE IF NOT EXISTS certifications
(
    certification_id bigserial primary key
    ,employee_id  BIGINT
    ,safety_training_program_id BIGINT
    ,number_certification Integer
--     ,PRIMARY KEY (employee_id, safety_training_program_id)
    ,UNIQUE (employee_id, safety_training_program_id)
    ,FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE
    ,FOREIGN KEY (safety_training_program_id) REFERENCES safety_training_programs(id) ON DELETE CASCADE
);
-- __________________________________________

CREATE TABLE IF NOT EXISTS safety_training_programs
(
    id BIGINT
    ,title_of_program  VARCHAR(45) NOT NULL
    ,program_number Integer NOT NULL
    ,duration Integer NOT NULL
    ,approved_the_program VARCHAR(45) NOT NULL
    ,date_of_approval DATE NOT NULL
--     ,certification_id bigserial REFERENCES  certifications (id)
--     ,UNIQUE (certification_id)
);

CREATE TABLE IF NOT EXISTS certifications
(
    id bigserial primary key
    ,number Integer NOT NULL
);
CREATE TABLE IF NOT EXISTS safety_training_programs
(
    id bigserial primary key
    ,title_of_program  VARCHAR(45) NOT NULL
    ,program_number Integer NOT NULL
    ,duration Integer NOT NULL
    ,approved_the_program VARCHAR(45) NOT NULL
    ,date_of_approval DATE NOT NULL
    ,certification_id BIGINT references certifications (id)
    ,UNIQUE (certification_id)
);
CREATE TABLE IF NOT EXISTS employee_program
(
    employee_id  BIGINT
    ,safety_training_program_id BIGINT
    ,PRIMARY KEY (employee_id, safety_training_program_id)
);
-- ____________________________________________

CREATE TABLE IF NOT EXISTS protocols
(
    id bigserial primary key
    ,date_of_examination  DATE NOT NULL
    ,chairman VARCHAR(45) NOT NULL
    ,one_member_of_commission VARCHAR(45) NOT NULL
    ,two_member_of_commission VARCHAR(45) NOT NULL
    ,three_member_of_commission VARCHAR(45) NOT NULL
    ,four_member_of_commission VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS regulationdocuments
(
    id bigserial primary key
    ,document_number  Integer NOT NULL
    ,title_of_document VARCHAR(45) NOT NULL
    ,approved_the_document VARCHAR(45)  NOT NULL
    ,date_of_approval DATE NOT NULL
);


