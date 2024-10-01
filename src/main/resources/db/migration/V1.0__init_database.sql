CREATE SEQUENCE plant_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE families (
    id VARCHAR(100) PRIMARY KEY ,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE plants (
    id BIGINT DEFAULT nextval('plant_sequence') PRIMARY KEY,
    common_name VARCHAR(100),
    status VARCHAR(15) NOT NULL,
    family_id VARCHAR(100),
    description TEXT,
    price NUMERIC(5, 2),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    last_modified_at TIMESTAMP WITH TIME ZONE,
    FOREIGN KEY (family_id) REFERENCES families
);

CREATE TABLE plant_classifications (
    plant_id BIGINT NOT NULL,
    classifications VARCHAR(255),
    FOREIGN KEY (plant_id) REFERENCES plants (id)
);

CREATE SEQUENCE IF NOT EXISTS information_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE information (
    id BIGINT PRIMARY KEY,
    plant_id BIGINT UNIQUE NOT NULL,
    origin VARCHAR(255),
    size VARCHAR(255),
    flowering VARCHAR(255),
    location VARCHAR(255),
    soil VARCHAR(255),
    fertilization VARCHAR(255),
    pruning VARCHAR(255),
    propagation VARCHAR(255),
    FOREIGN KEY (plant_id) REFERENCES plants (id)
);
