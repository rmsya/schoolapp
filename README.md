## Initialized
Init container for postgreSQL
```
docker-compose up -d
```

Test connect to database
```
docker exec -it postgres-container psql -U postgres -d academic_db
```

Create new database for each services
```
CREATE DATABASE payment_db;
CREATE DATABASE member_db;
```

## How to run
Run service
- member-service
- payment-service


## How to test
