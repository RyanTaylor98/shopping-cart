DROP TABLE IF EXISTS Books ;

CREATE TABLE IF NOT EXISTS Books  (
	Book_ref varchar(10) NOT NULL,
	Book_title varchar(60) NOT NULL,
	Book_price decimal(5,2) NOT NULL,
	Book_formats varchar(20) NOT NULL,
 	PRIMARY KEY ( Book_ref )
) ;

DROP TABLE IF EXISTS Members ;

CREATE TABLE IF NOT EXISTS Members  (
	Member_id int NOT NULL,
	Member_name varchar(30) NOT NULL,
 	PRIMARY KEY (Member_id)
) ;

DROP TABLE IF EXISTS Orders ;

CREATE TABLE IF NOT EXISTS Orders (
	Order_id int  NOT NULL AUTO_INCREMENT,
	Order_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ,
	Book_ref varchar(10) NOT NULL,
	Book_price decimal(5,2) NOT NULL,
	Formats_ordered varchar(20) NOT NULL,
	Member_id int NOT NULL,
	Download_id char(38) NOT NULL,
 	PRIMARY KEY (Order_id) ,
	foreign key ( Member_id) references Members ( Member_id ) ,
	foreign key ( Book_ref ) references Books( Book_ref )
) ;



