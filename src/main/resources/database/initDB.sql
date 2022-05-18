CREATE TABLE IF NOT EXISTS certifications
(
    id bigserial
    ,number Integer NOT NULL
);

CREATE TABLE IF NOT EXISTS employees
(
    id bigserial
    ,firstName  VARCHAR(45) NOT NULL
    ,lastName VARCHAR(45) NOT NULL
    ,patronymic VARCHAR(45)  NOT NULL
    ,jobposition VARCHAR(45)  NOT NULL
);

CREATE TABLE IF NOT EXISTS regulationdocuments
(
    id bigserial
    ,documentNumber  Integer NOT NULL
    ,titleOfDocument VARCHAR(45) NOT NULL
    ,approvedTheDocument VARCHAR(45)  NOT NULL
    ,dateOfApproval DATE NOT NULL
);



CREATE TABLE IF NOT EXISTS safetytrainingprograms
(
    id bigserial
    ,titleofprogram  VARCHAR(45) NOT NULL
    ,programNumber Integer NOT NULL
    ,duration Integer NOT NULL
    ,approvedtheprogram VARCHAR(45) NOT NULL
    ,dateofapproval DATE NOT NULL
)

CREATE TABLE IF NOT EXISTS protocols
(
    id bigserial
    ,dateOfExamination  DATE NOT NULL
    ,chairman VARCHAR(45) NOT NULL
    ,oneMemberOfCommission VARCHAR(45) NOT NULL
    ,twoMemberOfCommission VARCHAR(45) NOT NULL
    ,threeMemberOfCommission VARCHAR(45) NOT NULL
    ,fourMemberOfCommission VARCHAR(45) NOT NULL
)