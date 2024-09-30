CREATE SEQUENCE plant_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE families (
    id VARCHAR(100) NOT NULL,
    name VARCHAR(100) UNIQUE NOT NULL,
    PRIMARY KEY (id)
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
