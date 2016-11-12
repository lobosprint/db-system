#sudo -u postgres createuser --superuser turn4u
#psql -h localhost -U postgres -W -f create-user.sql postgres
sudo -u postgres dropdb turn4u
sudo -u postgres createdb turn4u
psql -h localhost -U turn4u -W -f create-database.sql turn4u
psql -h localhost -U turn4u -W -f insert-data.sql turn4u