@DROP SEQUENCE IF EXISTS SEQ_RESTAURANTS CASCADE;
DROP SEQUENCE IF EXISTS SEQ_TYPES_GASTRONOMIQUES CASCADE;
DROP SEQUENCE IF EXISTS seq_VILLES CASCADE;
DROP SEQUENCE IF EXISTS SEQ_EVAL CASCADE;
DROP SEQUENCE IF EXISTS SEQ_NOTES CASCADE;
DROP SEQUENCE IF EXISTS SEQ_CRITERES_EVALUATION CASCADE;

DROP TABLE IF EXISTS RESTAURANTS CASCADE;
DROP TABLE IF EXISTS TYPES_GASTRONOMIQUES CASCADE;
DROP TABLE IF EXISTS VILLES CASCADE;
DROP TABLE IF EXISTS COMMENTAIRES CASCADE;
DROP TABLE IF EXISTS LIKES CASCADE;
DROP TABLE IF EXISTS NOTES CASCADE;
DROP TABLE IF EXISTS CRITERES_EVALUATION CASCADE;

CREATE TABLE RESTAURANTS (numero integer PRIMARY KEY, nom varchar(100) NOT NULL, adresse varchar(100) NOT NULL, description text, site_web varchar(100), fk_type integer NOT NULL, fk_vill integer NOT NULL);
CREATE TABLE TYPES_GASTRONOMIQUES (numero integer PRIMARY KEY, libelle varchar(100) NOT NULL UNIQUE, description text NOT NULL);
CREATE TABLE VILLES (numero integer PRIMARY KEY, code_postal varchar(100) NOT NULL, nom_ville varchar(100) NOT NULL);
CREATE TABLE COMMENTAIRES (numero integer PRIMARY KEY, date_eval date NOT NULL, commentaire text NOT NULL, nom_utilisateur varchar(100) NOT NULL, fk_rest integer);
CREATE TABLE LIKES (numero integer PRIMARY KEY, appreciation char(1) NOT NULL, date_eval date NOT NULL, adresse_ip varchar(100) NOT NULL, fk_rest integer NOT NULL);
CREATE TABLE NOTES (numero integer PRIMARY KEY, note integer NOT NULL, fk_comm integer NOT NULL, fk_crit integer NOT NULL);
CREATE TABLE CRITERES_EVALUATION (numero integer PRIMARY KEY, nom varchar(100) NOT NULL UNIQUE, description varchar(512));

ALTER TABLE RESTAURANTS ADD FOREIGN KEY (fk_type) REFERENCES TYPES_GASTRONOMIQUES (numero);
ALTER TABLE RESTAURANTS ADD FOREIGN KEY (fk_vill) REFERENCES VILLES (numero);
ALTER TABLE COMMENTAIRES ADD FOREIGN KEY (fk_rest) REFERENCES RESTAURANTS (numero);
ALTER TABLE NOTES ADD FOREIGN KEY (fk_comm) REFERENCES COMMENTAIRES (numero);
ALTER TABLE NOTES ADD FOREIGN KEY (fk_crit) REFERENCES CRITERES_EVALUATION (numero);
ALTER TABLE LIKES ADD FOREIGN KEY (fk_rest) REFERENCES RESTAURANTS (numero);

CREATE SEQUENCE SEQ_RESTAURANTS;
CREATE SEQUENCE SEQ_TYPES_GASTRONOMIQUES;
CREATE SEQUENCE SEQ_VILLES;
CREATE SEQUENCE SEQ_EVAL;
CREATE SEQUENCE SEQ_NOTES;
CREATE SEQUENCE SEQ_CRITERES_EVALUATION;

CREATE OR REPLACE FUNCTION TR_BIF_RESTAURANTS() RETURNS TRIGGER AS $$
BEGIN
	IF NEW.numero IS NULL THEN
		NEW.numero := NEXTVAL('SEQ_RESTAURANTS');
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER TR_BIF_RESTAURANTS BEFORE INSERT ON RESTAURANTS FOR EACH ROW EXECUTE FUNCTION TR_BIF_RESTAURANTS();

CREATE OR REPLACE FUNCTION TR_BIF_TYPES_GASTRONOMIQUES() RETURNS TRIGGER AS $$
BEGIN
	IF NEW.numero IS NULL THEN
		NEW.numero := NEXTVAL('SEQ_TYPES_GASTRONOMIQUES');
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER TR_BIF_TYPES_GASTRONOMIQUES BEFORE INSERT ON TYPES_GASTRONOMIQUES FOR EACH ROW EXECUTE FUNCTION TR_BIF_TYPES_GASTRONOMIQUES();

CREATE OR REPLACE FUNCTION TR_BIF_VILLES() RETURNS TRIGGER AS $$
BEGIN
	IF NEW.numero IS NULL THEN
		NEW.numero := NEXTVAL('SEQ_VILLES');
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER TR_BIF_VILLES BEFORE INSERT ON VILLES FOR EACH ROW EXECUTE FUNCTION TR_BIF_VILLES();

CREATE OR REPLACE FUNCTION TR_BIF_COMMENTAIRES() RETURNS TRIGGER AS $$
BEGIN
	IF NEW.numero IS NULL THEN
		NEW.numero := NEXTVAL('SEQ_EVAL');
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER TR_BIF_COMMENTAIRES BEFORE INSERT ON COMMENTAIRES FOR EACH ROW EXECUTE FUNCTION TR_BIF_COMMENTAIRES();

CREATE OR REPLACE FUNCTION TR_BIF_LIKES() RETURNS TRIGGER AS $$
BEGIN
	IF NEW.numero IS NULL THEN
		NEW.numero := NEXTVAL('SEQ_EVAL');
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER TR_BIF_LIKES BEFORE INSERT ON LIKES FOR EACH ROW EXECUTE FUNCTION TR_BIF_LIKES();

CREATE OR REPLACE FUNCTION TR_BIF_NOTES() RETURNS TRIGGER AS $$
BEGIN
	IF NEW.numero IS NULL THEN
		NEW.numero := NEXTVAL('SEQ_NOTES');
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER TR_BIF_NOTES BEFORE INSERT ON NOTES FOR EACH ROW EXECUTE FUNCTION TR_BIF_NOTES();

CREATE OR REPLACE FUNCTION TR_BIF_CRITERES_EVALUATION() RETURNS TRIGGER AS $$
BEGIN
	IF NEW.numero IS NULL THEN
		NEW.numero := NEXTVAL('SEQ_CRITERES_EVALUATION');
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER TR_BIF_CRITERES_EVALUATION BEFORE INSERT ON CRITERES_EVALUATION FOR EACH ROW EXECUTE FUNCTION TR_BIF_CRITERES_EVALUATION();
