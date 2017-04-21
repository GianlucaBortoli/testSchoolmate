#
# INSERT USERS
# Admin, insegnanti, studenti, genitori 
#

INSERT INTO users (username, password, type) VALUES 
  ('maths',md5('maths'),'Teacher');
    INSERT INTO teachers (userid,fname,lname) VALUES
      (2,'maths','damaths');

INSERT INTO users (username, password, type) VALUES 
  ('english',md5('english'),'Teacher');
    INSERT INTO teachers (userid,fname,lname) VALUES
      (3,'english','daenglish');

INSERT INTO users (username, password, type) VALUES 
  ('science',md5('science'),'Teacher');
    INSERT INTO teachers (userid,fname,lname) VALUES
      (4,'science','dascience');

INSERT INTO users (username, password, type) VALUES 
  ('substitute',md5('substitute'),'Substitute');

INSERT INTO users (username, password, type) VALUES 
  ('student1',md5('student1'),'Student');
    INSERT INTO students (userid,fname,mi,lname) VALUES
      (6,'student1','a','dastud1');

INSERT INTO users (username, password, type) VALUES 
  ('student2',md5('student2'),'Student');
    INSERT INTO students (userid,fname,mi,lname) VALUES
      (7,'student2','b','dastud2');

INSERT INTO users (username, password, type) VALUES 
  ('student3',md5('student3'),'Student');
    INSERT INTO students (userid,fname,mi,lname) VALUES
      (8,'student3','c','dastud3');
  
INSERT INTO users (username, password, type) VALUES 
  ('student4',md5('student4'),'Student');
    INSERT INTO students (userid,fname,mi,lname) VALUES
      (9,'student4','d','dastud4');

INSERT INTO users (username, password, type) VALUES 
  ('student5',md5('student5'),'Student');
    INSERT INTO students (userid,fname,mi,lname) VALUES
      (10,'student5','f','dastud5');

INSERT INTO users (username, password, type) VALUES 
  ('parent1',md5('parent1'),'Parent');
    INSERT INTO parents (userid,fname,lname) VALUES
      (11,'parent1','daparent1');

INSERT INTO users (username, password, type) VALUES 
  ('parent2',md5('parent2'),'Parent');
    INSERT INTO parents (userid,fname,lname) VALUES
      (12,'parent2','daparent2');
  
INSERT INTO users (username, password, type) VALUES 
  ('parent3',md5('parent3'),'Parent');
    INSERT INTO parents (userid,fname,lname) VALUES
      (13,'parent3','daparent3');

INSERT INTO users (username, password, type) VALUES 
  ('admin',md5('admin'),'Admin');
    INSERT INTO adminstaff (userid,fname,lname) VALUES
      (14,'admin','daAdmin');

# INSERT PARENT STUDENTS MATCH
INSERT INTO parent_student_match (parentid,studentid) VALUES
  (1,1);
INSERT INTO parent_student_match (parentid,studentid) VALUES
  (1,2);
INSERT INTO parent_student_match (parentid,studentid) VALUES
  (2,3);
INSERT INTO parent_student_match (parentid,studentid) VALUES
  (2,4);
INSERT INTO parent_student_match (parentid,studentid) VALUES
  (3,5);

#
# INSERT TERMS
#
INSERT INTO terms (title, startdate, enddate) VALUES 
  ('FirstTerm',2016-09-01,2016-12-20);
INSERT INTO terms (title, startdate, enddate) VALUES 
  ('SecondTerm',2017-01-08,2017-05-30);
#
# INSERT SEMESTERS
#
INSERT INTO semesters (termid,title,startdate,midtermdate,enddate) VALUES
  (1,'FirstSemester',2016-09-01,2016-11-03,2016-12-20);
INSERT INTO semesters (termid,title,startdate,midtermdate,enddate) VALUES
  (2,'SecondSemester',2017-01-08,2017-03-21,2017-05-30);

#
# INSERT BULLETINS
#
INSERT INTO schoolbulletins (title,message,bulletindate) VALUES
  ('PlanChange','Informations about changing of school plan',2016-11-04);

#
# INSERT COURSES
#
INSERT INTO courses (semesterid,termid,coursename,teacherid,sectionnum,roomnum,periodnum,q1points,q2points,totalpoints) VALUES
  (1,1,'sec_test',1,1,1,1,1.1,1.1,2.2);
INSERT INTO courses (semesterid,termid,coursename,teacherid,sectionnum,roomnum,periodnum,q1points,q2points,totalpoints) VALUES
  (2,2,'net_sec',2,2,1,1,1.1,1.1,2.2);
