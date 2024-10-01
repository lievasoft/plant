CREATE SEQUENCE plant_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE families (
    id VARCHAR(100) PRIMARY KEY ,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS information_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE information (
    id BIGINT PRIMARY KEY,
    description TEXT,
    origin VARCHAR,
    size VARCHAR,
    flowering VARCHAR,
    location VARCHAR,
    soil VARCHAR,
    fertilization VARCHAR,
    pruning VARCHAR,
    propagation VARCHAR
);

CREATE TABLE plants (
    id BIGINT DEFAULT nextval('plant_sequence') PRIMARY KEY,
    information_id BIGINT UNIQUE NOT NULL,
    common_name VARCHAR(100),
    status VARCHAR(15) NOT NULL,
    family_id VARCHAR(100),
    price NUMERIC(5, 2),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    last_modified_at TIMESTAMP WITH TIME ZONE,
    FOREIGN KEY (family_id) REFERENCES families,
    FOREIGN KEY (information_id) REFERENCES information (id)
);

CREATE TABLE plant_classifications (
    plant_id BIGINT NOT NULL,
    classifications VARCHAR(255),
    FOREIGN KEY (plant_id) REFERENCES plants (id)
);
