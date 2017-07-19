INSERT INTO user_role VALUES(1, 'student');
INSERT INTO user_role VALUES(2, 'teacher');

INSERT INTO users(u_role_id, u_username, u_password, u_email, u_fname, u_lname) VALUES(1, 'jd', 'pass', 'bmckalipDev@gmail.com', 'john', 'doe');
INSERT INTO users(u_role_id, u_username, u_password, u_email, u_fname, u_lname) VALUES(2, 'sm', 'pass', 'bmckalipDev@gmail.com', 'sally', 'may');
commit;
