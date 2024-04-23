CREATE DATABASE IF NOT EXISTS cryptoREST;

SELECT table_name, column_name, data_type, character_maximum_length, is_nullable, column_default, column_key
FROM information_schema.columns
WHERE table_schema = 'cryptoREST';