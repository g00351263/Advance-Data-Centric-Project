insert into customers (CID, CNAME, LOANPERIOD) values (1, "John", 10);
insert into customers (CID, CNAME, LOANPERIOD) values (2, "Tom", 20);
insert into customers (CID, CNAME, LOANPERIOD) values (3, "Fred", 30);
insert into books (BID, TITLE, AUTHOR) values (100, "The Da Vinci Code", "Dan Brown");
insert into books (BID, TITLE, AUTHOR) values (101, "The Boy in the Striped Pyjamas", "John Boyne");
insert into books (BID, TITLE, AUTHOR) values (102, "Mayday", "Thomas Block");
insert into books (BID, TITLE, AUTHOR) values (103, "Runaway Jury", "John Grisham");
insert into books (BID, TITLE, AUTHOR) values (104, "Big Maggie", "John B. Keane");
insert into loans (LID, BID, CID, DUEDATE) values (2000, 100, 2, "2019-10-04");
insert into loans (LID, BID, CID, DUEDATE) values (2001, 101, 2, "2019-11-01");
insert into loans (LID, BID, CID, DUEDATE) values (2002, 104, 2, "2019-11-04");
insert into loans (LID, BID, CID, DUEDATE) values (2003, 103, 3, "2019-11-27");
