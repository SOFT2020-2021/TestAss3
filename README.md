# Test Assignment 3

#### postgres setup

##### Create bankuser
```sql
sudo -u postgres psql
CREATE DATABASE bank;
CREATE USER bankuser WITH ENCRYPTED PASSWORD 'secret';
GRANT ALL PRIVILEGES ON DATABASE bank TO bankuser;
ALTER USER bankuser CREATEDB;
``` 
#### setup authentication
in ``pg_hba.conf``, with path ``/etc/postgresql/12/main`` in ubuntu set it up like the following
```bash
# Database administrative login by Unix domain socket
local   all             postgres                                peer
local   all             bankuser				md5
# TYPE  DATABASE        USER            ADDRESS                 METHOD

# "local" is for Unix domain socket connections only
local   all             all                                     md5
# IPv4 local connections:
host    all             all             127.0.0.1/32            md5
# IPv6 local connections:
host    all             all             ::1/128                 md5
# Allow replication connections from localhost, by a user with the
# replication privilege.
local   replication     all                                     peer
host    replication     all             127.0.0.1/32            md5
host    replication     all             ::1/128                 md5

```

Remember to ``systemctl restart postgresql`` for changes to take effect


Lastly, we want to apologize for the 2 missing tests, being the ``AccountPerformerTest`` and the ``TransactionPerformerTest``.
