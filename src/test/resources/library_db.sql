drop table if exists books;
CREATE TABLE books (
  book_id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(45) NOT NULL,
  description varchar(45) NOT NULL,
  price decimal(10,0) NOT NULL,
  quantity int(11) NOT NULL,
  create_timestamp timestamp NULL DEFAULT NULL,
  PRIMARY KEY (book_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO books
(
title,
description,
price,
quantity,
create_timestamp)
VALUES
(
'My First Book',
'This is my first book.',
20,
10,
now());

INSERT INTO books
(
title,
description,
price,
quantity,
create_timestamp)
VALUES
(
'My Second Book',
'This is my second book.',
30,
40,
now());
