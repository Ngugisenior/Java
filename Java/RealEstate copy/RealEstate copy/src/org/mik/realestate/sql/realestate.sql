DROP TABLE realestate;
CREATE TABLE realestate ( id int not null primary key, 
                              address varchar(140), 
                              type int, 
                              price int, 
                              age int,
                              size int);

INSERT INTO realestate VALUES(1,'8783 Cattaraugus Ave,
Los Angeles, CA 90034',1, 200000, 50, 1007);
INSERT INTO realestate VALUES(2,'1618 W 46th St,
Los Angeles, CA 90062',1, 250000, 80, 2300);
INSERT INTO realestate VALUES(3,'Tobias Ave
Panorama City, CA 91402',1, 285000, 77, 1990);
