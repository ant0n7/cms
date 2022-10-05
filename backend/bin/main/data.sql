insert into tbl_role (id, rolename) values ('2895695a-f130-11ec-8ea0-0242ac120002', 'ADMIN');
insert into tbl_role (id, rolename) values ('2f1e573f-6290-4581-b54b-7e3ba2c98832', 'STUDENT');
insert into tbl_role (id, rolename) values ('0629910c-f847-4672-a11c-a80718f18026', 'TEACHER');

insert into tbl_authority (id, name) values ('aebe836e-83a6-4be7-84c5-1eda33a933fe', 'READ');
insert into tbl_authority (id, name) values ('dc1cb5ac-e142-4b6a-aa87-ce509cc7b5f0', 'CREATE');
insert into tbl_authority (id, name) values ('a0f02331-1baa-4428-984b-5cd4328f6f7b', 'UPDATE');
insert into tbl_authority (id, name) values ('c02e84f2-f069-483a-bd47-85833e7d1334', 'DELETE');

insert into tbl_role_authorities (role_id, authority_id) values ('0629910c-f847-4672-a11c-a80718f18026', 'aebe836e-83a6-4be7-84c5-1eda33a933fe');
insert into tbl_role_authorities (role_id, authority_id) values ('0629910c-f847-4672-a11c-a80718f18026', 'dc1cb5ac-e142-4b6a-aa87-ce509cc7b5f0');
insert into tbl_role_authorities (role_id, authority_id) values ('0629910c-f847-4672-a11c-a80718f18026', 'a0f02331-1baa-4428-984b-5cd4328f6f7b');
insert into tbl_role_authorities (role_id, authority_id) values ('0629910c-f847-4672-a11c-a80718f18026', 'c02e84f2-f069-483a-bd47-85833e7d1334');
insert into tbl_role_authorities (role_id, authority_id) values ('2f1e573f-6290-4581-b54b-7e3ba2c98832', 'aebe836e-83a6-4be7-84c5-1eda33a933fe');

insert into tbl_user (id, firstname, lastname, username, email, password) values ('498422fa-f130-11ec-8ea0-0242ac120002', 'Admin', 'Admin', 'administrator', 'admin@admin.com', '$2a$12$DiOin3ZyHX2aPFXdZiwLk.iEM0ZaLAfwACqNR3uqJLAl5kZeNdzsW');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('e74d2176-e7d7-4003-8543-369057a4279e', 'Andrin', 'Klarer', 'andrinklarer', 'andrin@teacher.com', '$2a$12$v9oHZkO7Sck8bQCtxn9s0OhqOxGS8d5ltc0J/mEzYXUQAey/qHeQO');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('2c61dac7-29fa-4baa-95e5-9053c7879d41', 'Anton', 'Detken', 'antondetken', 'anton@student.com', '$2a$12$Dz0YdddwYhFC9YSwWNEyI.wGbgI.8ZgIPz20OCThxqZQFOXvw3Cu6');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('9da0c2ba-98c5-4504-821a-259942a298b2', 'Bob', 'Bobber', 'bob', 'bob@student.com', '$2a$12$zP9Pmnx1C5gqqGUcc.WnmeDbeJcJUsBZtj1BXSutyNuhKhVqrCrFO');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('857fa2d5-3642-4d40-9465-c580a83c516e', 'Wandie', 'Iddens', 'wandieiddens', 'wandie@student.com', '$2a$12$4dGL.cYcLxxMl0wLkr3pGuUqFDqOG77HYS/L//AFAUNmQOdAJ0qTa');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('93057c93-6983-4744-be26-938f0bfb6c99', 'Blair', 'Von Welldun', 'blairvonwelldun', 'blair@student.com', '$2a$12$v7p2jzXhxUfc4a/l19kYeu1rGYVkbKGFNWM3Av/HqmUvnNEYBlqeK');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('1a238bcf-a3c2-4d0c-98fc-3e0ed1078b08', 'Averell', 'Sweetland', 'averellsweetland', 'averell@student.com', '$2a$12$7Bz2orl9p/7M.Y0CyouX7uGzhu7v7zOMh6kHnNzZNkph2yHkt9cUO');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('7b9318e2-3ce7-43c8-8e20-bf97ee66bd6c', 'Alaster', 'Carlesso', 'alastercarlesso', 'alaster@student.com', '$2a$12$wn7dWR2Ubxvj9RrBTYfP1eYzI7wTI8aJ82a2wyvKaf.O1juWUSSs6');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('b3689a1b-ea6c-43ce-a7f3-36b398cb5557', 'Douglas', 'Playhill', 'douglasplayhill', 'douglas@student.com', '$2a$12$RAPlIM6.MCdPySwr8GtBxue3FZkxw2FC4xNY4Gdnd8vlwccg0XGeW');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('d6682bc8-4e41-437f-9ac0-24230f5f904e', 'Klara', 'Mityushin', 'klaramityushin', 'klara@student.com', '$2a$12$ItGnGWDksbfcHw7Lg3bQgu290iP836Z8Q2ba1oujljKKMNa6rzBVS');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('d1c0502a-4fb5-4da4-aae9-d367af38772c', 'Happy', 'Orro', 'happyorro', 'happy@student.com', '$2a$12$p4ncSHUm19gqrOsAtZf4UuX3Ap476NgTF2ptrPyKdNrC3gogeNH4C');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('ee883683-e1ef-44f4-a3ee-45106686e060', 'Zack', 'Sturdey', 'zacksturdey', 'zack@student.com', '$2a$12$w3HQUInVZXPw7v5iJXn7G.W14m2El7ec6OqBGnwzbZFLp1S63rFb.');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('c8b37eed-b152-426d-a4dd-b56895eca322', 'Jolee', 'Eberdt', 'joleeeberdt', 'jolee@student.com', '$2a$12$oGaoQN9ANYgMPZPIFYjxx.ukeunghKJjPZBjf56rBIN3gOXASzFmy');
insert into tbl_user (id, firstname, lastname, username, email, password) values ('4c6e2546-31d0-465e-99cb-58acc9bc5b3b', 'Cassi', 'Moggle', 'cassimoggle', 'cassi@student.com', '$2a$12$W4XWOXi3vqUj0BDtdv18juXj3MOytS2MrMOk2ArE57efIxydsJhEO');


insert into tbl_user_role (user_id, role_id) values ('498422fa-f130-11ec-8ea0-0242ac120002', '2895695a-f130-11ec-8ea0-0242ac120002');
insert into tbl_user_role (user_id, role_id) values ('e74d2176-e7d7-4003-8543-369057a4279e', '0629910c-f847-4672-a11c-a80718f18026');
insert into tbl_user_role (user_id, role_id) values ('2c61dac7-29fa-4baa-95e5-9053c7879d41', '2f1e573f-6290-4581-b54b-7e3ba2c98832');
insert into tbl_user_role (user_id, role_id) values ('9da0c2ba-98c5-4504-821a-259942a298b2', '2f1e573f-6290-4581-b54b-7e3ba2c98832');

insert into tbl_user_role (user_id, role_id) values ('857fa2d5-3642-4d40-9465-c580a83c516e', '2f1e573f-6290-4581-b54b-7e3ba2c98832');
insert into tbl_user_role (user_id, role_id) values ('93057c93-6983-4744-be26-938f0bfb6c99', '2f1e573f-6290-4581-b54b-7e3ba2c98832');
insert into tbl_user_role (user_id, role_id) values ('1a238bcf-a3c2-4d0c-98fc-3e0ed1078b08', '2f1e573f-6290-4581-b54b-7e3ba2c98832');
insert into tbl_user_role (user_id, role_id) values ('7b9318e2-3ce7-43c8-8e20-bf97ee66bd6c', '2f1e573f-6290-4581-b54b-7e3ba2c98832');
insert into tbl_user_role (user_id, role_id) values ('b3689a1b-ea6c-43ce-a7f3-36b398cb5557', '2f1e573f-6290-4581-b54b-7e3ba2c98832');
insert into tbl_user_role (user_id, role_id) values ('d6682bc8-4e41-437f-9ac0-24230f5f904e', '2f1e573f-6290-4581-b54b-7e3ba2c98832');
insert into tbl_user_role (user_id, role_id) values ('d1c0502a-4fb5-4da4-aae9-d367af38772c', '2f1e573f-6290-4581-b54b-7e3ba2c98832');
insert into tbl_user_role (user_id, role_id) values ('ee883683-e1ef-44f4-a3ee-45106686e060', '2f1e573f-6290-4581-b54b-7e3ba2c98832');
insert into tbl_user_role (user_id, role_id) values ('c8b37eed-b152-426d-a4dd-b56895eca322', '2f1e573f-6290-4581-b54b-7e3ba2c98832');
insert into tbl_user_role (user_id, role_id) values ('4c6e2546-31d0-465e-99cb-58acc9bc5b3b', '2f1e573f-6290-4581-b54b-7e3ba2c98832');

INSERT INTO tbl_subject (id, subjectname) VALUES('7915ef79-e6ab-41d8-a510-2a7e75e503cf', 'Math');
INSERT INTO tbl_subject (id, subjectname) VALUES('aa000dde-d9c8-40a1-b0c7-d62ab5a480d4', 'English');
INSERT INTO tbl_subject (id, subjectname) VALUES('95e9feb9-f320-45c6-8b92-f69115f18186', 'French');
INSERT INTO tbl_subject (id, subjectname) VALUES('17981505-b651-4172-8b24-90914a76d57c', 'German');
INSERT INTO tbl_subject (id, subjectname) VALUES('e3a37a26-ac91-4377-bcae-d7edd8bc34d8', 'Economy');
INSERT INTO tbl_subject (id, subjectname) VALUES('51aea86c-239b-4b27-982e-816127be5b0b', 'History');

INSERT INTO tbl_class (id,classname) VALUES ('5148b858-f5fd-11ec-b939-0242ac120002','BIN10a');
INSERT INTO tbl_class (id,classname) VALUES ('1c1469b6-f18e-11ec-8ea0-0242ac120002','BIN20b');
INSERT INTO tbl_class (id,classname) VALUES ('20e3d92c-f18e-11ec-8ea0-0242ac120002','BIN30c');

INSERT INTO tbl_class_members (class_id,member_id) VALUES ('1c1469b6-f18e-11ec-8ea0-0242ac120002','2c61dac7-29fa-4baa-95e5-9053c7879d41');


INSERT INTO tbl_class_members (class_id,member_id) VALUES ('5148b858-f5fd-11ec-b939-0242ac120002','2c61dac7-29fa-4baa-95e5-9053c7879d41');
INSERT INTO tbl_class_members (class_id,member_id) VALUES ('5148b858-f5fd-11ec-b939-0242ac120002','e74d2176-e7d7-4003-8543-369057a4279e');
INSERT INTO tbl_class_members (class_id,member_id) VALUES ('5148b858-f5fd-11ec-b939-0242ac120002','1a238bcf-a3c2-4d0c-98fc-3e0ed1078b08');
INSERT INTO tbl_class_members (class_id,member_id) VALUES ('5148b858-f5fd-11ec-b939-0242ac120002','7b9318e2-3ce7-43c8-8e20-bf97ee66bd6c');
INSERT INTO tbl_class_members (class_id,member_id) VALUES ('5148b858-f5fd-11ec-b939-0242ac120002','b3689a1b-ea6c-43ce-a7f3-36b398cb5557');

INSERT INTO tbl_class_members (class_id,member_id) VALUES ('1c1469b6-f18e-11ec-8ea0-0242ac120002','d6682bc8-4e41-437f-9ac0-24230f5f904e');
INSERT INTO tbl_class_members (class_id,member_id) VALUES ('1c1469b6-f18e-11ec-8ea0-0242ac120002','d1c0502a-4fb5-4da4-aae9-d367af38772c');
INSERT INTO tbl_class_members (class_id,member_id) VALUES ('1c1469b6-f18e-11ec-8ea0-0242ac120002','ee883683-e1ef-44f4-a3ee-45106686e060');
INSERT INTO tbl_class_members (class_id,member_id) VALUES ('1c1469b6-f18e-11ec-8ea0-0242ac120002','c8b37eed-b152-426d-a4dd-b56895eca322');
INSERT INTO tbl_class_members (class_id,member_id) VALUES ('1c1469b6-f18e-11ec-8ea0-0242ac120002','4c6e2546-31d0-465e-99cb-58acc9bc5b3b');

INSERT INTO tbl_class_members (class_id,member_id) VALUES ('20e3d92c-f18e-11ec-8ea0-0242ac120002','857fa2d5-3642-4d40-9465-c580a83c516e');
INSERT INTO tbl_class_members (class_id,member_id) VALUES ('20e3d92c-f18e-11ec-8ea0-0242ac120002','93057c93-6983-4744-be26-938f0bfb6c99');
INSERT INTO tbl_class_members (class_id,member_id) VALUES ('20e3d92c-f18e-11ec-8ea0-0242ac120002','9da0c2ba-98c5-4504-821a-259942a298b2');


INSERT INTO tbl_class_subjects (class_id,subject_id) VALUES ('1c1469b6-f18e-11ec-8ea0-0242ac120002','51aea86c-239b-4b27-982e-816127be5b0b');
INSERT INTO tbl_class_subjects (class_id,subject_id) VALUES ('1c1469b6-f18e-11ec-8ea0-0242ac120002','e3a37a26-ac91-4377-bcae-d7edd8bc34d8');
INSERT INTO tbl_class_subjects (class_id,subject_id) VALUES ('1c1469b6-f18e-11ec-8ea0-0242ac120002','7915ef79-e6ab-41d8-a510-2a7e75e503cf');
INSERT INTO tbl_class_subjects (class_id,subject_id) VALUES ('20e3d92c-f18e-11ec-8ea0-0242ac120002','7915ef79-e6ab-41d8-a510-2a7e75e503cf');
INSERT INTO tbl_class_subjects (class_id,subject_id) VALUES ('20e3d92c-f18e-11ec-8ea0-0242ac120002','aa000dde-d9c8-40a1-b0c7-d62ab5a480d4');
INSERT INTO tbl_class_subjects (class_id,subject_id) VALUES ('20e3d92c-f18e-11ec-8ea0-0242ac120002','95e9feb9-f320-45c6-8b92-f69115f18186');
INSERT INTO tbl_class_subjects (class_id,subject_id) VALUES ('20e3d92c-f18e-11ec-8ea0-0242ac120002','17981505-b651-4172-8b24-90914a76d57c');

INSERT INTO tbl_class_subjects (class_id,subject_id) VALUES ('5148b858-f5fd-11ec-b939-0242ac120002','51aea86c-239b-4b27-982e-816127be5b0b');
INSERT INTO tbl_class_subjects (class_id,subject_id) VALUES ('5148b858-f5fd-11ec-b939-0242ac120002','e3a37a26-ac91-4377-bcae-d7edd8bc34d8');
INSERT INTO tbl_class_subjects (class_id,subject_id) VALUES ('5148b858-f5fd-11ec-b939-0242ac120002','95e9feb9-f320-45c6-8b92-f69115f18186');

