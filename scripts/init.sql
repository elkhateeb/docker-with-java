DROP TABLE IF EXISTS books CASCADE;
CREATE TABLE books(
  id         SERIAL,
  title       TEXT,
  author      TEXT,

  PRIMARY KEY (id)
);

INSERT INTO public.books(
  id, title, author)
VALUES (1, 'Clean Code', 'Robert Cecil Martin'),
  (2, 'The Art of Software Gardening', 'Patroklos Papapetrou');

CREATE SEQUENCE hibernate_sequence START 1;
SELECT setval('hibernate_sequence', (SELECT max(id) FROM public.books));