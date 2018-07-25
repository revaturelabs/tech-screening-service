-- DDL

create table scheduled_screening (
            id number(20) primary key,
    trainee_id number(20) not null,
    trainer_id number(20) not null,
 skill_type_id number(20),
        status varchar2(10),
scheduled_date timestamp
);

create table screening (
                     id number(20) primary key,
             trainee_id number(20) not null,
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

create table soft_skill_violation(
            id number(20) primary key,
         screening_id number(20),
    violation_type_id number(20),
                 time timestamp,
              comment varchar2(400)
);

create table violation_type(
            id number(20) primary key,
violation_type varchar2(100),
   description varchar(200)
);

create table question_score(
            id number(20) primary key,
   question_id number(20),
  screening_id number(20),
         score number(1),
       comment varchar2(400),
          time timestamp
);

create sequence QUESTION_SCORE_SEQUENCE;