drop table if exists books;

CREATE TABLE books (
  book_id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(45) NOT NULL,
  description varchar(45) NOT NULL,
  price decimal(10,0) NOT NULL,
  total_quantity int(11) NOT NULL,
  available_quantity int(11) NOT NULL,
  create_timestamp timestamp NULL DEFAULT NULL,
  PRIMARY KEY (book_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO books(title,description,price,total_quantity,available_quantity,create_timestamp) VALUES
('My First Book','This is my first book.',20,10,10,now());

DROP PROCEDURE IF EXISTS calculate_library_value;

CREATE PROCEDURE `calculate_library_value`()
BEGIN

	-- Total Value of Library books
	select sum(price * total_quantity) as library_Value from books;
	
	/*
		Also get all the books.
	*/

	BEGIN 
		select * from books order by title;
	END;

END;
