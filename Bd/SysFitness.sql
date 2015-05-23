--Inserir 

CREATE OR REPLACE FUNCTION inserir()
  RETURNS trigger AS
$BODY$
    BEGIN 
	Select 'Data de Hoje' || now;
	NEW
    END;
$BODY$
  LANGUAGE plpgsql;
  
CREATE TRIGGER baixa_nas_vendas
  BEFORE UPDATE
  ON produto
  FOR EACH ROW
  EXECUTE PROCEDURE baixa_produto();