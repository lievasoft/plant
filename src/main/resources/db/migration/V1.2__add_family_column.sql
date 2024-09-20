CREATE TABLE families (
    id varchar(100) NOT NULL,
    name VARCHAR(100) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE plants
    ADD COLUMN family_id VARCHAR(100);

ALTER TABLE IF EXISTS plants
    ADD CONSTRAINT fk_family_id
    FOREIGN KEY (family_id) REFERENCES families;

ALTER TABLE plants
    ALTER COLUMN common_name SET NOT NULL;

ALTER TABLE plants
    ADD CONSTRAINT unique_common_name UNIQUE (common_name);
