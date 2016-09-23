mysql_package:
  pkg.installed:
    - name: mysql-server

mysql_conf:
  file.managed:
    - name: /etc/my.cnf
    - source: salt://my.cnf
    - user: root
    - group: root
    - mode: 0644
    - require:
      - pkg: mysql_package

mysql_service:
  service:
    - name: mysqld
    - running
    - enable: True
    - require:
      - file: mysql_conf
    - watch:
      - file: mysql_conf

#MySQL-python:
#  pkg.installed
# required packages start
server_pkgs:
  pkg:
    - installed
    - pkgs:
      - python-dev
    - refresh: True

mysql_python_pkgs:
  pkg.installed:
    - pkgs:
      - libmysqlclient-dev
      - mysql-client
      - python-mysqldb
    - require:
      - pkg: server_pkgs

python-pip:
  pkg:
    - installed
    - refresh: False

mysql:
  pip.installed:
    - require:
      - pkg: python-pip
      - pkg: mysql_python_pkg
# required package end

stg_databases:
  mysql_database.present:
    - name: stagingdb
    - require:
      - pkg: mysql
      - service: mysql_service

first_db_user:
  mysql_user.present:
    - name: stg-admin
    - password: "pass4admin"
    - host: '%'
    - connection_charset: utf8
    - saltenv:
      - LC_ALL: "en_US.utf8"
    - require:
      - mysql_database: stg_databases

second_db_user:
  mysql_user.present:
    - name: stg-db
    - host: 'localhost'
    - password: "pass4dbuser"
    - connection_charset: utf8
    - saltenv:
      - LC_ALL: "en_US.utf8"
    - require:
      - mysql_database: stg_databases

create_first_table:
  mysql_query.run:
    - database: stagingdb
    - query: "create table first_table(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(100) NOT NULL, PRIMARY KEY ( id ));"
    - output:   "/tmp/create_first_table.txt"
    - require:
      - mysql_database: stg_databases

create_second_table:
  mysql_query.run:
    - database: stagingdb
    - query: "create table second_table(id INT, address VARCHAR(100));"
    - output:   "/tmp/create_second_table.txt"
    - require:
      - mysql_database: stg_databases

first_table_grants:
  mysql_grants.present:
    - grant: all privileges
    - database: stagingdb.*
    - user: stg-admin
    - host: '%'
    - require:
      - mysql_user: first_db_user

second_table_grants:
  mysql_grants.present:
    - grant: select,insert,update
    - database: stagingdb.second_table
    - user: stg-db
    - host: '%'
    - require:
      - mysql_user: second_db_user
