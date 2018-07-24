--------------------------------------------------------
--  DML for Sequence SCHEDULED_SCREENING
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
--  DML for Sequence SCREENING_ID_SEQUENCE
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
--  DML for Sequence VIOLATION_SEQUENCE
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
--  DML for Sequence SOFT_SKILL_VIOLATION_SEQUENCE
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
 

--------------------------------------------------------
--  DML for Sequence CANDIDATE
--------------------------------------------------------
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (1,'howard.johnson@hotmail.com','Howard Johnson','555-555-5555',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5500,'dlaut1@hotmail.com','Laut, Daniel','843-360-9205',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5501,'ckipp2@hotmail.com','Kipp, Charles','(480) 527-9139',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5502,'xinguang.huang1@gmail.com','Huang, Jason','208-830-8976',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5503,'osher.y.cohen@gmail.com','Cohen, Osher','347-524-1846','https://app.revature.com/profile/Osher/f341fc92cebe36b3753df749eeb57b2a','osher.y.cohen');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5504,'kchangfatt@gmail.com','Chang Fatt, Kyle','(917) 843-0464','https://app.revature.com/profile/kchangfatt/566988d360a8a0df93036e3e0d33e81f','kyle.changfatt');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5505,'nikolovski23@gmail.com','Nikolovski, Martino','347-593-9059','https://app.revature.com/profile/Martino/18411f7d60abb8d3ea9b8a12f9e32041','martino.23');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5506,'louisalopez93@gmail.com','Lopez, Louis','516-301-8490','https://app.revature.com/profile/LouisLopez/71fd9c8b9c4fc2fe20ec464e14e14c5d','louisalopez23');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5507,'syar0052@gmail.com','Yar, Shehar','(347) 653-0052','https://app.revature.com/profile/Shehar/f35ad0947a9108f7724aaadb3f0d311b','syar0052');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5508,'achen.this@gmail.com','Chen, Andrew','347-618-9852','https://app.revature.com/profile/AndrewChen/77a3861a405068e383f482fb2bcdc629','achen.this');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5509,'davidsibrian08@gmail.com','Sibrian, David','347-933-0847','https://app.revature.com/profile/davidsibrian08/fd4cf53dd3924a64a537f888b9713def','davidsibrian08_1');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5510,'karymacancela@gmail.com','Macancela, Karina','347-570-5804','https://app.revature.com/profile/kmacancela/4862d51e2c3940d37b5baf300e58962b','karymacancela');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5511,'shamlau23@gmail.com','Lau, Samuel','347-557-7626','https://app.revature.com/profile/shamlau/02c9c1073f9b3ab702f9c5db18fe9e6c','shamlau');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5512,'ychenq001@gmail.com','Chen, Yan','(347) 265-0886','https://app.revature.com/profile/ychen/bae900b010b8c778db2b8b93fafd3d67','YChenq001');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5513,'williams.andrew15@gmail.com','Williams, Andrew','914-255-5011','https://app.revature.com/profile/Gigantor15/c33772d90963ba311da91439c153ded4','williams.andrew15');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5514,'katz.rikki@gmail.com','Katz, Rikki','(516) 531-3671','https://app.revature.com/profile/RebeccaK/3d80c961cf1dab656b02aa6d1aaa95b4','rikkik13');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5515,'bcantos17@gmail.com','Cantos, Bryan','347-848-4163','https://app.revature.com/profile/bcantos17/1d1241150188ed37a992e84d4ee3ccf3','BCantos17');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5516,'travis.dacosta1@gmail.com','Dacosta, Travis','347-500-7612','https://app.revature.com/profile/tdacosta11/9c0a7e4de28a8898c2b9186debe0e7cb','travisdac');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5517,'ilysiarh@gmail.com','Siarheyeu, Ilya','347-334-1704','https://app.revature.com/profile/ilysiarh/1612b1d54369bfa052cb56c24334040f','ilysiarh');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5518,'wingz101@icloud.com','Fredericksen-Rasberry, Salim','(516) 825-1848',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5519,'bankole726@gmail.com','Thomas, Bankole','3476527223',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5520,'davedataram@gmail.com','Dataram, Dave','347-986-0617',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5521,'azraelzzz@hotmail.com','In Choi, Hou','(347) 459-2016',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5522,'chandradatgir@yahoo.com','Gir, Chandradat','347-447-7487',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5523,'jcsanchez1218@yahoo.com','Carlos Sanchez, Juan','(347) 641-8146',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5524,'mcartagenaez8@gmail.com','Cartagena, Michael','347-782-4731','https://app.revature.com/profile/MichaelC/55b6b9a398dacdb90093a3088822d35c','mcart5566');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5525,'tanland20@gmail.com','Peralta, Yanilda','347-638-1605','https://app.revature.com/profile/Synac/254a7187dfc32f6f50710a56bd8112f6','eclipsesunsettreesynch');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5526,'son.jack0218@gmail.com','Duong, Jack','(646) 417-3976','https://app.revature.com/profile/imrjack/fab72b5d62b5965bcd22aabe0a9ee24b','imrjack');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5527,'hvalcin.grady@gmail.com','Valcin, Hendy','347-272-0040','https://app.revature.com/profile/Hendy/4991db30a308e99aff23eead11daa716','live:196c1fe19236d6c6');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5528,'hossain.yahya@outlook.com','Yahya, Hossain','347-595-0959','https://app.revature.com/profile/Hossain/56533488cfec931bbc8e43ba02f12190','live:hossain.yahya_1');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5529,'denise.j.montesdeoca@gmail.com','Montesdeoca, Denise','347-536-7727','https://app.revature.com/profile/dmontesdeoca/4ddfb0697a3c1fff8d16e6a1ce46348c','live:55f3683c5bb7165c');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5530,'fareed.ali37@qmail.cuny.edu','Ali, Fareed','347-526-5184','https://app.revature.com/profile/fareed/03198a1e81a3f4e32433a9e9c9db353e','live:bassph');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5531,'kamlam@live.com','Lam, Kam','917-951-1138','https://app.revature.com/profile/Kamlam02/0b64db75d34cddd8b96f8091e44d57b7','live:89f575098655f2b');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5532,'sadat.t.ahmed@gmail.com','Ahmed, Sadat','646-407-7707','https://app.revature.com/profile/SadatAhmed/9b198abd1d0d88022d593375b61ed041','sadat.t.ahmed');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5533,'pieryospp@gmail.com','Yos, Pier','347-238-4965','https://app.revature.com/profile/Peacepapi/22e027610567ad08a4c6698a8dbfa74b','pieryospp');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5534,'ateebtahir@gmail.com','Khawaja, Ateeb','347-251-9865','https://app.revature.com/profile/KMAT/eab7a80a000dc662a9c098b80259c013','ateebtahir');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5535,'suditw@gmail.com','Itwaru, Sudish','718-415-0517','https://app.revature.com/profile/sitwaru/8995f5191fdba7a3508ed6e9825863e1','sudish.itwaru');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5536,'danliu277@gmail.com','Liu, Daniel','646-275-2027','https://app.revature.com/profile/DanielLiu/8ec745c0558385ae50ac8c25324d7bb3','danliu277');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5537,'guankev@gmail.com','Guan, Kevin','347-447-1888','https://app.revature.com/profile/KevinG92/2ba062861641fbf4e956c517983952c4','live:kevguan');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5538,'connelsp@gmail.com','Connelly, Sean','718-772-1455','https://app.revature.com/profile/Seanelly/64c09ac289741de8bf7ec0f81f2ad5ad','seanelly08');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5539,'igorgluskin@yahoo.com','Gluskin, Igor','347-791-1360','https://app.revature.com/profile/IgorGluskin/ae6866d406461c1c36de8df7c0a1a7a7','igor.gluskin');
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5352,'jgt.tech@gmail.com','Tech, Jonathon','(918) 504-6831',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5350,'kh04548@georgiasouthern.edu','Haas, Kevin','(229) 255-7639',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5351,'ifouche10@gmail.com','Fouche, Issac','(301) 606-8749',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5353,'wyatt.duling@gmail.com','Duling, Wyatt','563-343-3075',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5354,'zhuang4@buffalo.edu','Huang, Jimmy','(917) 916-6881',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5355,'encastillo92@gmail.com','Castillo, Erika','(229) 669-3805',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5356,'m.blanchard@post.com','Blanchard, Martin','(603) 264-0369',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5357,'manyaam13@gmail.com','Almatar, Manya','(773) 954-9254',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5358,'dsantonov1990@gmail.com','Antonov, Denis','(678) 763-6648',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5359,'rrpglad@gmail.com','Peters, Russell','(240) 678-7156',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5360,'jbspruce@gmail.com','Spruce, Jason','417-793-2382',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5361,'taddetlef@hotmail.com','Detlef, Tad','980-254-4343',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5362,'tylerwelborn91@yahoo.com','Welborn, Tyler','(806) 831-8984',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5363,'yanznln@gmail.com','Lin, Yan','(646) 641-9538',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5540,'tmcdeane@gmail.com','McDeane, Trey',null,null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5402,'justin.atkinson.1990@gmail.com','Atkinson, Justin','267-229-1865',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5400,'nbrown.joshua@yahoo.com','Brown, Joshua','301-917-4594',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5401,'eyekno3w@hotmail.com','Lovell, Jeffrey','414-801-6881',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5450,'tonyhill_1981@yahoo.com','Hill, Anthony','312-752-0406',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5451,'fjyoung19@gmail.com','Young, Fagbemi','(757) 478-5280',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5452,'swong8295@gmail.com','Wong, Steven','(757) 289-6297',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5453,'mro2352@gmail.com','Olson, Matthew','(573) 382-4546',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5454,'sidak_dhillon@hotmail.com','Dhillon, Sidak','6783083035',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5455,'dennyayard@yahoo.com','Ayard, Denny','626-394-8606',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5456,'forsbergjj@gmail.com','Forsberg, Justin','(763) 614-9683',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5457,'nbrasco@msn.com','Brasco, Nick','(856) 472-1674',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5458,'alexanderjhajek@gmail.com','Hajek, Alexander','(507) 990-7261',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5459,'wenyuan.will@gmail.com','Wan, William','(908) 616-7543',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5460,'mr.eric.erwin@gmail.com','Erwin, Eric','(701) 500-9782',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5461,'lukehboggs@gmail.com','Boggs, Luke','(630) 338-6039',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5462,'patz1@umbc.edu','Zebron, Patrick','443-668-9955',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5463,'wjandrz@earthlink.net','Andrzejewski, Walter','(813) 892-2173',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5464,'wheeler146@yahoo.com','Wheeler, Justin','(760) 508-2059',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5465,'alex.michels94@hotmail.com','Michels, Alex','(661) 435-3844',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5466,'christopherlolney@gmail.com','Olney, Chris','(270) 535-1997',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5467,'bookofbromon@gmail.com','Smith, Carter','(402) 650-7288',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5468,'starrv2011@gmail.com','Starr, Valencia','347-770-6819',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5469,'hrich558@live.kutztown.edu','Richiez, Hector','(347) 247-9731',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5470,'patterdl@clarkson.edu','Patterson, Dalton','(518) 481-7979',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5471,'kotayaaron@yahoo.com','Kotay Jr., Aaron','(704) 412-0890',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5472,'barkercbel@gmail.com','Barker, Cory','(360) 204-6555',null,null);
Insert into CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5473,'dominicjb4@hotmail.com','Bartholomeo, Dominic','757-327-8076',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5474, 'dschrute@mailinator.com','Schrute, Dwight','700-864-1234',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) values (5475, 'jhalpert@mailinator.com','Halpert, Jim','700-864-2345',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5477, 'amartin@mailinator.com','Martin, Angela','700-864-4567',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5478, 'kmalone@mailinator.com','Malone, Kevin','700-864-5678',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5479, 'abernard@mailinator.com','Bernard, Andy','700-864-6789',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5480, 'gadams@mailinator.com','Adams, Gary','700-864-7890',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5481, 'elawrence@mailinator.com','Lawrence, Elaine','700-864-8901',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5482, 'qleyton@mailinator.com','Leyton, Quinn','700-864-9012',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5483, 'dcoke@mailinator.com','Coke, Donovan','700-864-0123',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5484,'bparish@mailinator.com','Parish, Brian','700-865-1234',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5485,'tbrewster@mailinator.com','Brewster, Tera','700-865-2345',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5486,'gjohnson@mailinator.com','Johnson, Garrett','700-865-3456',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5487,'kwood@mailinator.com','Wood, Kelly','700-865-4567',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5488,'mrose@mailinator.com','Rose, Marissa','700-865-5678',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5489,'lhex@mailinator.com','Hex, Leonard','700-865-6789',null,null);
INSERT INTO CANDIDATE (ID,EMAIL,NAME,PHONE_NUMBER,PROFILE_URL,SKYPE_ID) VALUES (5490, 'sgermanotta@mailinator.com','Germanotta, Stefani','700-865-7890',null,null);


COMMIT;
