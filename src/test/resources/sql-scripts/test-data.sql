
CREATE TABLE IF NOT EXISTS movies (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  minutes INT NOT NULL,
  genre VARCHAR(50) NOT NULL,
  director VARCHAR(50) NOT NULL
);

insert into movies (name, minutes, genre, director) values
    ('Dark Knight', 152, 'ACTION', 'Christopher Nolan'),
    ('Memento', 113, 'THRILLER', 'Christopher Nolan'),
    ('Matrix', 136, 'ACTION','The Wachowskis'),
    ('The Dark', 95, 'HORROR', 'Justin P. Lange');

