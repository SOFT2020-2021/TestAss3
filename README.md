## bank-backend


#### postgres setup

```
sudo -u postgres psql
CREATE DATABASE bank;
CREATE USER bankuser WITH ENCRYPTED PASSWORD 'secret';
GRANT ALL PRIVILEGES ON DATABASE bank TO bankuser;
``` 
