CREATE TABLE dipendente (
 azienda_id INT(255) NOT NULL,
 nome varchar(255) NOT NULL,
 cognome varchar(255) NOT NULL,
 codice_fiscale varchar(11) NOT NULL,
 luogo_nascita varchar(255) NOT NULL,
 data_nascita DATE NOT NULL,
 residenza varchar(255) NOT NULL,
 domicilio varchar(255),
 cellulare varchar(15) NOT NULL,
 email varchar(255) NOT NULL,
 PRIMARY KEY (codice_fiscale)
);

CREATE TABLE cliente (
 regione_sociale varchar(255) NOT NULL,
 sede_legale varchar(255) NOT NULL,
 partita_iva varchar(11) NOT NULL,
 codice_fiscale varchar(11),
 codice_interscambio varchar(7) NOT NULL,
 pec varchar(255),
 PRIMARY KEY (partita_iva)
);

CREATE TABLE commessa (
 codice varchar(20) NOT NULL,
 descrizione_commessa varchar(255) NOT NULL,
 tipologia_commessa varchar(30) NOT NULL,
 importo FLOAT(20),
 data_inizio_commessa DATE NOT NULL,
 data_fine_commessa DATE,
 cliente_partita_iva varchar(11) NOT NULL,
 PRIMARY KEY (codice)
);

CREATE TABLE dipendente_commessa (
 dipendente_codice_fiscale varchar(11) NOT NULL,
 commessa_codice varchar(20) NOT NULL,
 tariffa_gg INT(4),
 data_inizio_attivita DATE NOT NULL,
 data_fine_attivita DATE,
 PRIMARY KEY (dipendente_codice_fiscale,commessa_codice)
);

CREATE TABLE contratto (
 id INT(255) NOT NULL AUTO_INCREMENT,
 dipendente_codice_fiscale varchar(11) NOT NULL,
 tipologia_contratto INT(255) NOT NULL,
 livello INT(1) NOT NULL,
 costo_gg FLOAT(6) NOT NULL,
 data_inizio_contratto DATE NOT NULL,
 data_fine_contratto DATE NOT NULL,
 retribuzione_lorda FLOAT(8) NOT NULL,
 rimborso_spese_mensili FLOAT(8) NOT NULL,
 note varchar(255),
 PRIMARY KEY (id)

);

CREATE TABLE azienda (
 id INT(255) NOT NULL AUTO_INCREMENT,
 nome varchar(255) NOT NULL,
 PRIMARY KEY (id)

);

CREATE TABLE tipologia_contratto (
 id INT(255) NOT NULL AUTO_INCREMENT,
 tipologia varchar(255) NOT NULL,
 PRIMARY KEY (id)

);

ALTER TABLE dipendente ADD CONSTRAINT dipendente_fk0 FOREIGN KEY (azienda_id) REFERENCES azienda(id)
;

ALTER TABLE commessa ADD CONSTRAINT commessa_fk0 FOREIGN KEY (cliente_partita_iva) REFERENCES cliente(partita_iva);

ALTER TABLE dipendente_commessa ADD CONSTRAINT dipendente_commessa_fk0 FOREIGN KEY (dipendente_codice_fiscale) REFERENCES dipendente(codice_fiscale);

ALTER TABLE dipendente_commessa ADD CONSTRAINT dipendente_commessa_fk1 FOREIGN KEY (commessa_codice) REFERENCES commessa(codice);

ALTER TABLE contratto ADD CONSTRAINT contratto_fk0 FOREIGN KEY (dipendente_codice_fiscale) REFERENCES dipendente(codice_fiscale);

ALTER TABLE contratto ADD CONSTRAINT contratto_fk1 FOREIGN KEY (tipologia_contratto) REFERENCES tipologia_contratto(id)
;