CREATE TABLE reservation (
  id IDENTITY PRIMARY KEY,
  description VARCHAR(50) NOT NULL, 
  detailed_description VARCHAR(500),
  start TIMESTAMP,
  end TIMESTAMP,
  user_id bigint,
  resource_id bigint
);