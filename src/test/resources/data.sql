TRUNCATE TABLE CANDIDATE;
TRUNCATE TABLE SCHEDULED_SCREENING;
TRUNCATE TABLE SCREENING;
TRUNCATE TABLE VIOLATION_TYPE;
TRUNCATE TABLE SOFT_SKILL_VIOLATION;

--------------------------------------------------------
--  DML for Sequence CANDIDATE
--------------------------------------------------------
DROP SEQUENCE  CANDIDATE_SEQUENCE;
CREATE SEQUENCE    CANDIDATE_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 1;

INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (CANDIDATE_SEQUENCE.NEXTVAL, 'dschrute@mailinator.com','Schrute, Dwight','700-864-1234',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (CANDIDATE_SEQUENCE.NEXTVAL, 'jhalpert@mailinator.com','Halpert, Jim','700-864-2345',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'amartin@mailinator.com','Martin, Angela','700-864-4567',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'kmalone@mailinator.com','Malone, Kevin','700-864-5678',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'abernard@mailinator.com','Bernard, Andy','700-864-6789',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'gadams@mailinator.com','Adams, Gary','700-864-7890',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'elawrence@mailinator.com','Lawrence, Elaine','700-864-8901',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'qleyton@mailinator.com','Leyton, Quinn','700-864-9012',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'dcoke@mailinator.com','Coke, Donovan','700-864-0123',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'bparish@mailinator.com','Parish, Brian','700-865-1234',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'tbrewster@mailinator.com','Brewster, Tera','700-865-2345',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'gjohnson@mailinator.com','Johnson, Garrett','700-865-3456',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'kwood@mailinator.com','Wood, Kelly','700-865-4567',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'mrose@mailinator.com','Rose, Marissa','700-865-5678',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'lhex@mailinator.com','Hex, Leonard','700-865-6789',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'sgermanotta@mailinator.com','Germanotta, Stefani','700-865-7890',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'elawrence@mailinator.com','Lawrence, Elaine','700-864-8901',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'qleyton@mailinator.com','Leyton, Quinn','700-864-9012',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'dcoke@mailinator.com','Coke, Donovan','700-864-0123',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'bparish@mailinator.com','Parish, Brian','700-865-1234',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'tbrewster@mailinator.com','Brewster, Tera','700-865-2345',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'gjohnson@mailinator.com','Johnson, Garrett','700-865-3456',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'kwood@mailinator.com','Wood, Kelly','700-865-4567',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'mrose@mailinator.com','Rose, Marissa','700-865-5678',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL,'lhex@mailinator.com','Hex, Leonard','700-865-6789',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (CANDIDATE_SEQUENCE.NEXTVAL, 'sgermanotta@mailinator.com','Germanotta, Stefani','700-865-7890',null,null);

--------------------------------------------------------
--  DML for Sequence SCHEDULED_SCREENING
--------------------------------------------------------
DROP SEQUENCE  SCHEDULED_SCREENING_SEQUENCE;
CREATE SEQUENCE    SCHEDULED_SCREENING_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 1;

insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 51, 48, 1, 'SCREENED', (SYSDATE+13));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 54, 49, 2, 'SCREENED', (SYSDATE+17));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 51, 48, 3, 'SCREENED', (SYSDATE+2));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 53, 49, 4, 'PENDING', (SYSDATE+6));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 52, 21, 5, 'SCREENED', (SYSDATE+35));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 51, 48, 6, 'PENDING', (SYSDATE+6));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 52, 12, 7, 'PENDING', (SYSDATE+1));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 56, 12, 8, 'PENDING', (SYSDATE+13));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 53, 28, 9, 'SCREENED', (SYSDATE+4));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 55, 48, 10, 'PENDING', (SYSDATE+9));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 55, 51, 11, 'SCREENED', (SYSDATE+12));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 51, 51, 12, 'SCREENED', (SYSDATE+11));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 54, 51, 13, 'PENDING', (SYSDATE+9));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 53, 49, 15, 'PENDING', (SYSDATE+8));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 56, 12, 16, 'PENDING', (SYSDATE+2));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 54, 28, 17, 'PENDING', (SYSDATE+19));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 53, 48, 18, 'SCREENED', (SYSDATE+24));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 51, 49, 19, 'SCREENED', (SYSDATE+20));
insert into SCHEDULED_SCREENING (id, skill_type_id, trainer_id, candidate_id, status, scheduled_date) values (SCHEDULED_SCREENING_SEQUENCE.NEXTVAL, 55, 48, 20, 'SCREENED', (SYSDATE+1));

--------------------------------------------------------
--  DML for Sequence SCREENING_ID_SEQUENCE
--------------------------------------------------------
DROP SEQUENCE  SCREENING_SEQUENCE;
CREATE SEQUENCE    SCREENING_SEQUENCE  MINVALUE 1  INCREMENT BY 1 START WITH 1;

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 3 , 1 , 2, 50.0, 'intoComment','generalComment','softskillComment', '2018-03-01', '2018-03-02', 0, 'Completed', 1);
 
 Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
 START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 3 , 2 , 2, 50.0, 'intoComment2','generalComment2','softskillComment2', '2018-03-02', '2018-03-03', 0, 'Completed', 2);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 4 , 3 , 2, 50.0, 'intoComment3','generalComment3','softskillComment3', '2018-03-04', '2018-03-05', 0, 'Completed', 3);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 5 , 4 , 2, 50.0, 'intoComment4','generalComment4','softskillComment4', '2018-03-06', '2018-03-07', 0, 'Completed', 4);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 5 , 5 , 2, 50.0, 'intoComment5','generalComment5','softskillComment5', '2018-03-08', '2018-03-09', 1, 'Pending', 5);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL , 5 , 6 , 2, 50.0, 'intoComment6','generalComment6','softskillComment6', '2018-03-10', '2018-03-11', 1, 'Pending', 6);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL , 3 , 7 , 2, 50.0, 'intoComment7','generalComment7','softskillComment7', '2018-03-11', '2018-03-12', 0, 'Pending', 7);

Insert into SCREENING (ID, TRAINER_ID, CANDIDATE_ID, SKILL_TYPE_ID, 
COMPOSITE_SCORE, ABOUT_COMMENT, GENERAL_COMMENT, SOFT_SKILL_COMMENT,
START_DATE, END_DATE, SOFT_SKILL_VERDICT, STATUS, SCHEDULED_SCREENING_ID) 
values (SCREENING_SEQUENCE.NEXTVAL, 3 , 8 , 2, 50.0, 'intoComment8','generalComment8','softskillComment8', '2018-03-12', '2018-03-14', 1, 'Pending', 8);
 

--------------------------------------------------------
--  DML for Sequence VIOLATION_SEQUENCE
--------------------------------------------------------
DROP SEQUENCE  VIOLATION_SEQUENCE;
CREATE SEQUENCE   VIOLATION_SEQUENCE MINVALUE 1 INCREMENT BY 1 START WITH 1;

Insert into VIOLATION_TYPE (ID, violation_type, DESCRIPTION) 
values (VIOLATION_SEQUENCE.NEXTVAL, 'Profanity', 'Expletives were used.');

Insert into VIOLATION_TYPE (ID, violation_type, DESCRIPTION) 
values (VIOLATION_SEQUENCE.NEXTVAL, 'Attire', 'Attire was not appropriate.');

Insert into VIOLATION_TYPE (ID, violation_type, DESCRIPTION) 
values (VIOLATION_SEQUENCE.NEXTVAL, 'Unfocused', 'Focus was not fully on the screening.');

--------------------------------------------------------
--  DML for Sequence SOFT_SKILL_VIOLATION_SEQUENCE
--------------------------------------------------------
DROP SEQUENCE  SOFT_SKILL_VIOLATION_SEQUENCE;
CREATE SEQUENCE   SOFT_SKILL_VIOLATION_SEQUENCE MINVALUE 1 INCREMENT BY 1 START WITH 1;

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

--------------------------------------------------------
--  DML for Sequence QUESTION_SCORE_SEQUENCE
--------------------------------------------------------
Insert into QUESTION_SCORE (ID, QUESTION_ID, SCREENING_ID, SCORE, COMMENT, TIME) 
values (QUESTION_SCORE_SEQUENCE.NEXTVAL, 1, 1, 3,'Basic knowledge, average.', '2018-03-01');
Insert into QUESTION_SCORE (ID, QUESTION_ID, SCREENING_ID, SCORE, COMMENT, TIME) 
values (QUESTION_SCORE_SEQUENCE.NEXTVAL, 2, 1, 2,'some understanding.', '2018-03-01');
Insert into QUESTION_SCORE (ID, QUESTION_ID, SCREENING_ID, SCORE, COMMENT, TIME) 
values (QUESTION_SCORE_SEQUENCE.NEXTVAL, 3, 1, 5,'good', '2018-03-01');
Insert into QUESTION_SCORE (ID, QUESTION_ID, SCREENING_ID, SCORE, COMMENT, TIME) 
values (QUESTION_SCORE_SEQUENCE.NEXTVAL, 4, 1, 5,'good', '2018-03-01');
Insert into QUESTION_SCORE (ID, QUESTION_ID, SCREENING_ID, SCORE, COMMENT, TIME) 
values (QUESTION_SCORE_SEQUENCE.NEXTVAL, 4, 1, 1,'Bad wording, not sure they understand', '2018-03-01');

Insert into QUESTION_SCORE (ID, QUESTION_ID, SCREENING_ID, SCORE, COMMENT, TIME) 
values (QUESTION_SCORE_SEQUENCE.NEXTVAL, 1, 2, 3,'Basic knowledge, average.', '2018-03-01');
Insert into QUESTION_SCORE (ID, QUESTION_ID, SCREENING_ID, SCORE, COMMENT, TIME) 
values (QUESTION_SCORE_SEQUENCE.NEXTVAL, 2, 2, 2,'some understanding.', '2018-03-01');
Insert into QUESTION_SCORE (ID, QUESTION_ID, SCREENING_ID, SCORE, COMMENT, TIME) 
values (QUESTION_SCORE_SEQUENCE.NEXTVAL, 3, 2, 5,'good', '2018-03-01');
Insert into QUESTION_SCORE (ID, QUESTION_ID, SCREENING_ID, SCORE, COMMENT, TIME) 
values (QUESTION_SCORE_SEQUENCE.NEXTVAL, 4, 2, 5,'good', '2018-03-01');
Insert into QUESTION_SCORE (ID, QUESTION_ID, SCREENING_ID, SCORE, COMMENT, TIME) 
values (QUESTION_SCORE_SEQUENCE.NEXTVAL, 4, 2, 1,'Bad wording, not sure they understand', '2018-03-01');

COMMIT;