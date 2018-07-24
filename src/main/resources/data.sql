--------------------------------------------------------
--  DDL for Sequence SCHEDULED_SCREENING
--------------------------------------------------------
DROP SEQUENCE IF EXISTS SCHEDULED_SCREENING_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  SCHEDULED_SCREENING_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 5600;

insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 51, 48, 5501, 'SCREENED', (SYSDATE+13));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 54, 49, 5502, 'SCREENED', (SYSDATE+17));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 51, 48, 5503, 'SCREENED', (SYSDATE+2));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 53, 49, 5504, 'PENDING', (SYSDATE+6));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 52, 21, 5505, 'SCREENED', (SYSDATE+35));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 51, 48, 5506, 'PENDING', (SYSDATE+6));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 52, 12, 5507, 'PENDING', (SYSDATE+1));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 56, 12, 5508, 'PENDING', (SYSDATE+13));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 53, 28, 5509, 'SCREENED', (SYSDATE+4));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 55, 48, 5510, 'PENDING', (SYSDATE+9));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 55, 51, 5511, 'SCREENED', (SYSDATE+12));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 51, 51, 5512, 'SCREENED', (SYSDATE+11));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 54, 51, 5513, 'PENDING', (SYSDATE+9));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 53, 49, 5515, 'PENDING', (SYSDATE+8));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 56, 12, 5516, 'PENDING', (SYSDATE+2));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 54, 28, 5517, 'PENDING', (SYSDATE+19));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 53, 48, 5518, 'SCREENED', (SYSDATE+24));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 51, 49, 5519, 'SCREENED', (SYSDATE+20));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 55, 48, 5520, 'SCREENED', (SYSDATE+1));

--------------------------------------------------------
--  DDL for Sequence SCREENING_ID_SEQUENCE
--------------------------------------------------------
DROP SEQUENCE IF EXISTS SCREENING_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  SCREENING_SEQUENCE  MINVALUE 5600  INCREMENT BY 1 START WITH 5600;

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 3 , 5500 , 2, 50.0, 'intoComment','generalComment','softskillComment', '2018-03-01', '2018-03-02', 0, 'Completed', 1);
 
 Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
 START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 3 , 5501 , 2, 50.0, 'intoComment2','generalComment2','softskillComment2', '2018-03-02', '2018-03-03', 0, 'Completed', 2);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 4 , 5502 , 2, 50.0, 'intoComment3','generalComment3','softskillComment3', '2018-03-04', '2018-03-05', 0, 'Completed', 3);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 5 , 5503 , 2, 50.0, 'intoComment4','generalComment4','softskillComment4', '2018-03-06', '2018-03-07', 0, 'Completed', 4);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 5 , 5504 , 2, 50.0, 'intoComment5','generalComment5','softskillComment5', '2018-03-08', '2018-03-09', 1, 'Pending', 5);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL , 5 , 5505 , 2, 50.0, 'intoComment6','generalComment6','softskillComment6', '2018-03-10', '2018-03-11', 1, 'Pending', 6);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL , 3 , 5506 , 2, 50.0, 'intoComment7','generalComment7','softskillComment7', '2018-03-11', '2018-03-12', 0, 'Pending', 7);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 3 , 5507 , 2, 50.0, 'intoComment8','generalComment8','softskillComment8', '2018-03-12', '2018-03-14', 1, 'Pending', 8);
 
COMMIT;

--------------------------------------------------------
--  DDL for Sequence VIOLATION_SEQUENCE
--------------------------------------------------------
DROP SEQUENCE IF EXISTS VIOLATION_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  VIOLATION_SEQUENCE  MINVALUE 5600  INCREMENT BY 1 START WITH 5600;

Insert into VIOLATION_TYPE (ID, violation_type, DESCRIPTION) 
values (VIOLATION_SEQUENCE.NEXTVAL, 'Profanity', 'Expletives were used.');

Insert into VIOLATION_TYPE (ID, violation_type, DESCRIPTION) 
values (VIOLATION_SEQUENCE.NEXTVAL, 'Attire', 'Attire was not appropriate.');

Insert into VIOLATION_TYPE (ID, violation_type, DESCRIPTION) 
values (VIOLATION_SEQUENCE.NEXTVAL, 'Unfocused', 'Focus was not fully on the screening.');

COMMIT;

--------------------------------------------------------
--  DDL for Sequence SOFT_SKILL_VIOLATION_SEQUENCE
--------------------------------------------------------
DROP SEQUENCE IF EXISTS SOFT_SKILL_VIOLATION_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  SOFT_SKILL_VIOLATION_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 1;

Insert into SOFT_SKILL_VIOLATION (ID, SCREENING_ID, VIOLATION_TYPE_ID, COMMENT, TIME) 
values (SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 1, 1, 'After failing a question, candidate started swearing.', '2018-03-01');
Insert into SOFT_SKILL_VIOLATION (ID, SCREENING_ID, VIOLATION_TYPE_ID, COMMENT, TIME)  
values (SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 1, 1, 'Swore when yelling out to someone else behind him.', '2018-03-02');
Insert into SOFT_SKILL_VIOLATION (ID, SCREENING_ID, VIOLATION_TYPE_ID, COMMENT, TIME) 
values (SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 3, 2, 'Was wearing pajamas', '2018-03-03');
Insert into SOFT_SKILL_VIOLATION (ID, SCREENING_ID, VIOLATION_TYPE_ID, COMMENT, TIME) 
values (SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 3, 2, 'Wearing a graphic t-shirt.', '2018-03-04');
Insert into SOFT_SKILL_VIOLATION (ID, SCREENING_ID, VIOLATION_TYPE_ID, COMMENT, TIME) 
values (SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 5, 3, 'Had many people in the same room. Was drinking.', '2018-03-05');
Insert into SOFT_SKILL_VIOLATION (ID, SCREENING_ID, VIOLATION_TYPE_ID, COMMENT, TIME)  
values (SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 5, 3, 'He kept wandering off topic, was browsing a site.', '2018-03-06');
Insert into SOFT_SKILL_VIOLATION (ID, SCREENING_ID, VIOLATION_TYPE_ID, COMMENT, TIME) 
values (SOFT_SKILL_VIOLATION_SEQUENCE.NEXTVAL, 7, 3, 'Extremely distracted, was texting.', '2018-03-07');
 

COMMIT;
