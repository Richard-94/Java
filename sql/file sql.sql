CREATE TABLE IF NOT EXISTS client (
	client_number SERIAL PRIMARY KEY,
	name_client VARCHAR NOT NULL,
	surname VARCHAR NOT NULL,
	date_birth DATE NOT NULL,
	region VARCHAR NOT NULL
);


CREATE TABLE IF NOT EXISTS providers (
	provider_number SERIAL PRIMARY KEY,
	denomination VARCHAR NOT NULL,
	region_residence VARCHAR NOT NULL

);


CREATE TABLE IF NOT EXISTS expenses  (
	expensesNumber SERIAL PRIMARY KEY,
	type_work VARCHAR NOT NULL,
	import_number DECIMAL NOT NULL,
	iva INTEGER NOT NULL,
	id_client VARCHAR NOT NULL,
	expense_date DATE NOT NULL,
	client_number VARCHAR NOT NULL,
	CONSTRAINT expenses_providers_FK FOREIGN KEY (client_number) REFERENCES providers(provider_number)

);

ALTER TABLE expenses ALTER COLUMN iva TYPE VARCHAR;


CREATE TABLE IF NOT EXISTS products (
	id_product SERIAL PRIMARY KEY,
	description VARCHAR NOT NULL,
	in_produzione BOOLEAN DEFAULT TRUE,
	on_selling BOOLEAN DEFAULT TRUE,
	activation_date DATE NOT NULL,
	disactivation_date DATE
);

INSERT INTO client (name_client, surname, date_birth, region) VALUES 
('John', 'Doe', '1990-07-15', 'California'),
('Emily', 'Smith', '1982-04-28', 'New York'),
('Michael', 'Johnson', '1975-11-02', 'Texas'),
('Sarah', 'Anderson', '1982-09-10', 'Florida');


INSERT INTO  providers(denomination, region_residence ) 
		VALUES 	('Epicode SRL', 'Lazio'),
				('JavaSchool SPA', 'Piemonte')
				
				
								
INSERT INTO expenses(type_work, import_number , iva, id_client, expense_date, client_number) 
		VALUES 	('A', '145.12', '10%', 2, '2/2/2022', 1),
				('B', '533.99', '20%', 1, '29/4/2022', 2),
				('A', '145.12', '20%', 3, '12/1/2023', 1),
				('A', '188.00', '15%', 2, '2/2/2023', 1);
				
				
INSERT INTO products (description, in_produzione, on_selling,  activation_date , disactivation_date)
		VALUES 	('Prodotto x', true, false, '29/4/2017', '29/4/2023'),
				('Prodotto z', true, true, '15/9/2016', '15/9/2024'),
				('Prodotto q', false, false, '12/12/2017', '12/9/2022');				




SELECT * FROM client;


--esercizio 1
SELECT name_client, surname FROM client WHERE EXTRACT(YEAR FROM date_birth) = 1982;



--esercizio 2
SELECT COUNT(*) AS "nuova iva" FROM expenses WHERE iva = '20%';

--esercizio 3





