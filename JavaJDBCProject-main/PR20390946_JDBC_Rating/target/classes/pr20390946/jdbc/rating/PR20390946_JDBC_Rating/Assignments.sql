
create table AssignmentsTable(
	serialNo int,
	studentName varchar(10),
	subject varchar(20),
	assignmentCategory varchar(10),
	dateOfSubmission varchar(20),
	points int(3)
);

create table DistributionsTable(
	assignmentCategory varchar(20),
	weight int(3)
);

insert into AssignmentsTable values
(1,'Ananth','Electro Fields','test_1','21-Jul-16',100),
(2,'Bhagath','Electro Fields','test_1','21-Jul-16',78),
(3,'Chaya','Electro Fields','test_1','21-Jul-16',68),
(4,'Esharath','Electro Fields','test_1','21-Jul-16',87),
(5,'Bhagath','Electro Fields','quiz_1','22-Jul-16',20),
(6,'Chaya','Electro Fields','lab_1','23-Jul-16',10),
(7,'Ananth','Electro Fields','project_1','24-Jul-16',100),
(8,'Davanth','Electro Fields','project_1','24-Jul-16',100),
(9,'Bhagath','Electro Fields','quiz_2','25-Jul-16',50),
(10,'Ananth','Electro Fields','quiz_1','26-Jul-16',100),
(11,'Bhagath','Electro Fields','lab_1','27-Jul-16',10),
(12,'Chaya','Electro Fields','project_1','28-Jul-16',100),
(13,'Bhagath','Electro Fields','project_1','28-Jul-16',100),
(14,'Ananth','Computing Techniques','test_1','29-Jul-16',86),
(15,'Ananth','Electro Fields','quiz_2','29-Jul-16',100),
(16,'Bhagath','Computing Techniques','project_1','30-Jul-16',100),
(17,'Ananth','Electro Fields','lab_1','30-Jul-16',100),
(18,'Chaya','Computing Techniques','quiz_1','31-Jul-16',20),
(19,'Ananth','Electro Fields','test_2','1-Aug-16',100),
(20,'Chaya','Electro Fields','test_2','1-Aug-16',92);

insert into DistributionsTable values
('Test',40),
('Quiz', 20),
('Lab Work', 10),
('Project', 30);

create table RatingCalculator(
        studentName varchar(10),
        subject varchar(25),
        testScore float(4), 
        quizScore float(4), 
        labScore float(4), 
        projectScore float(4),
        overallRating float(4)
        counter int(1)
);

insert into RatingCalculator value(null , null, 0, 0, 0 ,0, 0, 0); 

