DROP TABLE IF EXISTS esrd.role_child_role CASCADE;
DROP TABLE IF EXISTS esrd.user_roles CASCADE;
DROP TABLE IF EXISTS esrd.doc_number_prefixes CASCADE;
DROP TABLE IF EXISTS esrd.doctype_routes CASCADE;
DROP TABLE IF EXISTS esrd.doc_agreement CASCADE;
DROP TABLE IF EXISTS esrd.department CASCADE;
DROP TABLE IF EXISTS esrd.department_child_departments CASCADE;
DROP TABLE IF EXISTS esrd.users CASCADE;
DROP TABLE IF EXISTS esrd.field_child_field CASCADE;
DROP TABLE IF EXISTS esrd.fields_roles CASCADE;
DROP TABLE IF EXISTS esrd.doctype_fields CASCADE;
DROP TABLE IF EXISTS esrd.field CASCADE;
DROP TABLE IF EXISTS esrd.valuedfield_child_valued_field CASCADE;
DROP TABLE IF EXISTS esrd.doc_valuedfields CASCADE;
DROP TABLE IF EXISTS esrd.doc CASCADE;
DROP TABLE IF EXISTS esrd.doctype CASCADE;
DROP TABLE IF EXISTS esrd.role CASCADE;
DROP TABLE IF EXISTS esrd.valuedfield CASCADE;
DROP TABLE IF EXISTS esrd.catalogelem CASCADE;
DROP TABLE IF EXISTS esrd.catalog CASCADE;
DROP TABLE IF EXISTS esrd.organization CASCADE;
DROP TABLE IF EXISTS esrd.resolution CASCADE;
DROP TABLE IF EXISTS esrd.resolutions_users CASCADE;
DROP TABLE IF EXISTS esrd.users_distribution_departments CASCADE;
DROP TABLE IF EXISTS esrd.users_delegation_users CASCADE;
DROP TABLE IF EXISTS esrd.html_tables CASCADE;
DROP TABLE IF EXISTS publish_data CASCADE;

DROP SEQUENCE IF EXISTS esrd.global_seq CASCADE;
DROP SEQUENCE IF EXISTS esrd.agreement_seq CASCADE;
DROP SEQUENCE IF EXISTS esrd.memo_seq CASCADE;
DROP SEQUENCE IF EXISTS esrd.protocol_seq CASCADE;
DROP SEQUENCE IF EXISTS esrd.decree_seq CASCADE;
CREATE SEQUENCE esrd.global_seq START 100000;
CREATE SEQUENCE esrd.agreement_seq START 1;
CREATE SEQUENCE esrd.memo_seq START 1;
CREATE SEQUENCE esrd.protocol_seq START 1;
CREATE SEQUENCE esrd.decree_seq START 1;

CREATE TABLE esrd.role
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    name            VARCHAR                 NOT NULL
);

CREATE TABLE esrd.role_child_role
(
    role_id          INTEGER                         NOT NULL,
    child_role_id    INTEGER                         NOT NULL,
    FOREIGN KEY (role_id) REFERENCES esrd.role (id) ON DELETE CASCADE,
    FOREIGN KEY (child_role_id) REFERENCES esrd.role (id) ON DELETE CASCADE
);

CREATE TABLE esrd.department
(
    id                    INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    top_level             BOOLEAN,
    chief_user_id         INTEGER                          ,
    name                  VARCHAR
);

CREATE TABLE esrd.department_child_departments
(
    department_id           INTEGER                NOT NULL,
    child_departments_id    INTEGER                NOT NULL
);

CREATE TABLE esrd.users
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    name        VARCHAR                 NOT NULL,
    lastname    VARCHAR                         ,
    firstname   VARCHAR                         ,
    patronym    VARCHAR                         ,
    position    VARCHAR                         ,
    short_position   VARCHAR                    ,
    full_position    VARCHAR                    ,
    dative_fullname  VARCHAR                    ,
    dative_position  VARCHAR                    ,
    email       VARCHAR                         ,
    phone       VARCHAR                         ,
    department_id INTEGER                       ,
    FOREIGN KEY (department_id) REFERENCES esrd.department (id) ON DELETE CASCADE
);

CREATE TABLE esrd.user_roles
(
    user_id          INTEGER            NOT NULL,
    role_id          INTEGER            NOT NULL,
    FOREIGN KEY (user_id) REFERENCES esrd.users (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES esrd.role (id) ON DELETE CASCADE
);

CREATE TABLE esrd.users_delegation_users
(
    user_id               INTEGER                 NOT NULL,
    delegation_users_id    INTEGER                         ,
    FOREIGN KEY (user_id) REFERENCES esrd.users (id) ON DELETE CASCADE,
    FOREIGN KEY (delegation_users_id) REFERENCES esrd.users (id) ON DELETE CASCADE
);

CREATE TABLE esrd.doc_number_prefixes
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    name       VARCHAR      NOT NULL
);

CREATE TABLE esrd.doctype
(
    id                      INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    name                    VARCHAR                 NOT NULL,
    appendix_template_filename   VARCHAR                         ,
    template_filename       VARCHAR                         ,
    role_id                 INTEGER                 NOT NULL,
    doc_number_prefix_id    INTEGER                 NOT NULL,
    final_doc               BOOLEAN                 NOT NULL,
    publish_name_mask       VARCHAR                         ,
    publish_classifier_params   VARCHAR                     ,
    FOREIGN KEY (role_id) REFERENCES esrd.role (id) ON DELETE CASCADE,
    FOREIGN KEY (doc_number_prefix_id) REFERENCES esrd.doc_number_prefixes (id) ON DELETE CASCADE
);

CREATE TABLE esrd.doc
(
    id                      INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    doctype_id              INTEGER                      NOT NULL,
    reg_num                 VARCHAR                              ,
    reg_datetime            TIMESTAMP                            ,
    project_reg_num         VARCHAR                      NOT NULL,
    project_reg_datetime    TIMESTAMP DEFAULT now()      NOT NULL,
    insert_datetime         TIMESTAMP DEFAULT now()      NOT NULL,
    docstatus               VARCHAR                      NOT NULL,
    url_pdf                 VARCHAR                              ,
    initial_user_id         INTEGER                              ,
    parent_doc_id           INTEGER                              ,
    FOREIGN KEY (doctype_id) REFERENCES esrd.doctype (id) ON DELETE CASCADE,
    FOREIGN KEY (initial_user_id) REFERENCES esrd.users (id) ON DELETE CASCADE
);

CREATE TABLE esrd.doctype_routes
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    doctype_id       INTEGER                 NOT NULL,
    user_id          INTEGER                 NOT NULL,
    agree_stage      INTEGER                 NOT NULL,
    FOREIGN KEY (doctype_id) REFERENCES esrd.doctype (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES esrd.users (id) ON DELETE CASCADE
);

CREATE TABLE esrd.doc_agreement
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    ordering         INTEGER                 NOT NULL,
    doc_id           INTEGER                 NOT NULL,
    user_id          INTEGER                 NOT NULL,
    returned_user_id INTEGER                         ,
    agreed_datetime  TIMESTAMP                       ,
    comment          VARCHAR                         ,
    decision_type    VARCHAR                         ,
    final_user       BOOLEAN                         ,
    cur_user         BOOLEAN                         ,
    origin_user_id   INTEGER                         ,
    FOREIGN KEY (doc_id) REFERENCES esrd.doc (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES esrd.users (id) ON DELETE CASCADE
);

/*
CREATE TABLE doc_routes
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    doctype_id       INTEGER                 NOT NULL,
    userldap         VARCHAR                 NOT NULL,
    agree_order      INTEGER                 NOT NULL,
    FOREIGN KEY (doctype_id) REFERENCES doctype (id) ON DELETE CASCADE
);*/

CREATE TABLE esrd.catalog
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    parent_catalog_id    INTEGER                         ,
    name             VARCHAR                 NOT NULL,
    catalogtype_id       INTEGER                 NOT NULL
);

CREATE TABLE esrd.catalogelem
(
    id                      INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    value_int               INTEGER                         ,
    value_str               VARCHAR                         ,
    value_str_preposition   VARCHAR                         ,
    catalog_id              INTEGER                 NOT NULL,
    parent_catalogelem_id   INTEGER                         ,
    FOREIGN KEY (catalog_id) REFERENCES esrd.catalog (id) ON DELETE CASCADE
);

CREATE TABLE esrd.field
(
    id                INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    name              VARCHAR                 NOT NULL,
    fieldtype         VARCHAR                 NOT NULL,
    position_in_group INTEGER                         ,
    max_count         INTEGER                         ,
    length            INTEGER                         ,
    catalog_id        INTEGER                         ,
    appendix          BOOLEAN DEFAULT FALSE           ,
    tag               VARCHAR                         ,
    FOREIGN KEY (catalog_id) REFERENCES esrd.catalog (id) ON DELETE CASCADE
);

CREATE TABLE esrd.field_child_field
(
    field_id          INTEGER                         ,
    child_field_id    INTEGER                         ,
    FOREIGN KEY (field_id) REFERENCES esrd.field (id) ON DELETE CASCADE,
    FOREIGN KEY (child_field_id) REFERENCES esrd.field (id) ON DELETE CASCADE
);

CREATE TABLE esrd.fields_roles
(
    id                INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    doctype_id        INTEGER                 NOT NULL,
    field_id          INTEGER                 NOT NULL,
    required          BOOLEAN DEFAULT FALSE   NOT NULL,
    role_id           INTEGER                         ,
    FOREIGN KEY (doctype_id) REFERENCES esrd.doctype (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES esrd.role (id) ON DELETE CASCADE
);

CREATE TABLE esrd.doctype_fields
(
    id                INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    doctype_id          INTEGER                 NOT NULL,
    field_id            INTEGER                 NOT NULL,
    position            INTEGER                 NOT NULL,
    CONSTRAINT c_doctype_fields UNIQUE (doctype_id, field_id, position),
    FOREIGN KEY (doctype_id) REFERENCES esrd.doctype (id) ON DELETE CASCADE,
    FOREIGN KEY (field_id) REFERENCES esrd.field (id) ON DELETE CASCADE
);

CREATE TABLE esrd.valuedfield
(
    id                INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    field_id          INTEGER                 NOT NULL,
    catalogelem_id    INTEGER                         ,
    value_int         INTEGER                         ,
    value_str         VARCHAR                         ,
    value_date        DATE                            ,
    value_time        TIME                            ,
    value_datetime    TIMESTAMP                       ,
    FOREIGN KEY (catalogelem_id) REFERENCES esrd.catalogelem (id) ON DELETE CASCADE
);

CREATE TABLE esrd.valuedfield_child_valued_field
(
    valued_field_id          INTEGER                         ,
    child_valued_field_id    INTEGER                         ,
    FOREIGN KEY (valued_field_id) REFERENCES esrd.valuedfield (id) ON DELETE CASCADE,
    FOREIGN KEY (child_valued_field_id) REFERENCES esrd.valuedfield (id) ON DELETE CASCADE
);

CREATE TABLE esrd.doc_valuedfields
(
    id                     INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    doc_id                 INTEGER                 NOT NULL,
    valuedfield_id         INTEGER                 NOT NULL,
    position               INTEGER                 NOT NULL,
    FOREIGN KEY (doc_id) REFERENCES esrd.doc (id) ON DELETE CASCADE,
    FOREIGN KEY (valuedfield_id) REFERENCES esrd.valuedfield (id) ON DELETE CASCADE
);

CREATE TABLE esrd.organization
(
    id                     INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    short_name_lf          VARCHAR                 NOT NULL,
    full_name_lf           VARCHAR                 NOT NULL,
    ogrn                   VARCHAR                 NOT NULL,
    inn                    VARCHAR                 NOT NULL,
    kpp                    VARCHAR                 NOT NULL,
    address                VARCHAR                 NOT NULL,
    fio_manager            VARCHAR                 NOT NULL,
    position_manager       VARCHAR                 NOT NULL,
    CONSTRAINT c_organization UNIQUE (inn)
);

CREATE TABLE esrd.resolution
(
    id                         INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    ordering                   INTEGER NOT NULL,
    doc_id                     INTEGER NOT NULL,
    primary_resolution         BOOLEAN,
    control_date               DATE,
    execution_datetime         TIMESTAMP,
    department_id              INTEGER NOT NULL,
    FOREIGN KEY (doc_id) REFERENCES esrd.doc (id) ON DELETE CASCADE,
    FOREIGN KEY (department_id) REFERENCES esrd.department (id) ON DELETE CASCADE
);

CREATE TABLE esrd.resolutions_users
(
    id                         INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    resolution_datetime        TIMESTAMP,
    user_id                    INTEGER,
    resolution_id              INTEGER,
    FOREIGN KEY (user_id) REFERENCES esrd.users (id) ON DELETE CASCADE,
    FOREIGN KEY (resolution_id) REFERENCES esrd.resolution (id) ON DELETE CASCADE
);

CREATE TABLE esrd.html_tables
(
    id                         INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    name                       VARCHAR,
    html_content               VARCHAR
);

CREATE TABLE esrd.users_distribution_departments
(
    user_id                         INTEGER NOT NULL,
    distribution_departments_id     INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES esrd.users (id) ON DELETE CASCADE,
    FOREIGN KEY (distribution_departments_id) REFERENCES esrd.department (id) ON DELETE CASCADE
);

CREATE TABLE esrd.publish_data
(
    id                         INTEGER PRIMARY KEY DEFAULT nextval('esrd.global_seq'),
    mosru                      BOOLEAN NOT NULL DEFAULT FALSE,
    mosru_datetime             TIMESTAMP,
    basereg                    INTEGER,
    basereg_datetime           TIMESTAMP,
    ri                         BOOLEAN NOT NULL DEFAULT FALSE,
    ri_datetime                TIMESTAMP,
    doc_id                     INTEGER NOT NULL,
    FOREIGN KEY (doc_id) REFERENCES esrd.doc (id) ON DELETE CASCADE
);

CREATE OR REPLACE FUNCTION esrd.generateDocNumber (mask VARCHAR, optional VARCHAR DEFAULT NULL)
    RETURNS VARCHAR AS $$
DECLARE Result VARCHAR;
DECLARE yearPostfix VARCHAR;
BEGIN
    yearPostfix = SUBSTRING(CAST(DATE_PART('year', CURRENT_DATE) AS text),3);
    IF (mask='согл') THEN
        SELECT 'согл-'||nextval('esrd.agreement_seq')||'/'||yearPostfix INTO Result;
    ELSIF (mask='ДПР-П') THEN
        SELECT 'ДПР-П-'||optional||'/'||yearPostfix INTO Result;
    ELSIF (mask='ДПР-СЗ') THEN
        SELECT 'ДПР-СЗ-'||nextval('esrd.memo_seq')||'/'||yearPostfix INTO Result;
    ELSIF (mask='ДПР-ПРО') THEN
        SELECT 'ДПР-ПРО-'||nextval('esrd.protocol_seq')||'/'||yearPostfix INTO Result;
    ELSIF (mask='ДПР-ПР') THEN
        SELECT 'ДПР-ПР-'||nextval('esrd.decree_seq')||'/'||yearPostfix INTO Result;
    ELSE
        RAISE 'Incorrect mask for generating document number' USING ERRCODE = 'INCORRECT_DOCNUMBER_MASK';
    END IF;
    RETURN Result;
END; $$ LANGUAGE plpgsql;


