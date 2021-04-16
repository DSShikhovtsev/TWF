Docker postgres:
docker run --name twf -p 5432:5432 -e POSTGRES_PASSWORD=twf -e POSTGRES_DB=twf -d postgres

Соответственно port:5432 user:postgres, pass:twf, db:twf
