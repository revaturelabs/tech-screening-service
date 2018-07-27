-- DDL
drop table if exists candidate;
create table if not exists candidate(
		       	id number(20) primary key,
       resource_id varchar2(50),
		      name varchar2(100),
             email varchar2(100),
      phone_number varchar2(20),
          skype_id varchar2(100),
       profile_url varchar2(100),
    recruiter_name varchar2(100),
           college varchar2(100),
            degree varchar2(100),
             major varchar2(100),
tech_screener_name varchar2(100)
);

drop table if exists scheduled_screening;
create table if not exists scheduled_screening (
            id number(20) primary key,
  candidate_id number(20) not null,
    trainer_id number(20) not null,
 skill_type_id number(20),
        status varchar2(10),
scheduled_date timestamp
);

drop table if exists screening;
create table if not exists screening (
          id number(20) primary key,
           candidate_id number(20) not null,
             trainer_id number(20) not null,
          skill_type_id number(20),
        composite_score number(5, 2),
          about_comment varchar2(400),
        general_comment varchar2(400),
     soft_skill_comment varchar2(400),
             start_date timestamp,
               end_date timestamp,
     soft_skill_verdict number(1),
                 status varchar2(10),
 scheduled_screening_id number(20)
);

drop table if exists violation_type;
create table if not exists violation_type(
            id number(20) primary key,
violation_type varchar2(100),
   description varchar2(200)
);

drop table if exists soft_skill_violation;
create table if not exists soft_skill_violation(
        id number(20) primary key,
         screening_id number(20) unique,
    violation_type_id number(20),
                 time timestamp,
              comment varchar2(400)
);


drop table if exists question_score;
create table if not exists question_score(
            id number(20) primary key,
   question_id number(20) not null,
  screening_id number(20) not null,
         score number(1),
       comment varchar2(400),
          time timestamp
);




DROP SEQUENCE IF EXISTS QUESTION_SCORE_SEQUENCE;

CREATE SEQUENCE  IF NOT EXISTS  QUESTION_SCORE_SEQUENCE;

DROP SEQUENCE IF EXISTS SCHEDULED_SCREENING_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  SCHEDULED_SCREENING_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 1;

DROP SEQUENCE IF EXISTS SCREENING_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  SCREENING_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 1;

DROP SEQUENCE IF EXISTS VIOLATION_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  VIOLATION_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 1;

DROP SEQUENCE IF EXISTS SOFT_SKILL_VIOLATION_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  SOFT_SKILL_VIOLATION_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 1;

DROP SEQUENCE IF EXISTS CANDIDATE_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  CANDIDATE_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 1;


