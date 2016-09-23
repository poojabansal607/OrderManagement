include:
  - install_jdk8

tomcat-server:
  archive:
    - extracted
    - name: /opt/
    - source: http://www.us.apache.org/dist/tomcat/tomcat-9/v9.0.0.M1/bin/apache-tomcat-9.0.0.M1.tar.gz
    - source_hash: md5=e794b1c8a4d1427db42b3cc033e0ba2e
    - archive_format: tar
    - if_missing: /opt/apache-tomcat-9.0.0.M1/

tomcat_symlink:
  file.symlink:
    - name: /opt/tomcat
    - target: apache-tomcat-9.0.0.M1
    - require:
      - archive: tomcat-server

deploy_war:
  tomcat.war_deployed:
    - name: /order-management
    - war: salt://application/order-management.war
    - force: True
    - require:
      - file: /opt/tomcat

tomcat_server_start_direct:
  cmd.run:
    - name: /opt/tomcat/bin/startup.sh
    - unless: 'ps -ef | grep apache.catalina.startup.Bootstra[p]'
    - require:
      - file: tomcat_symlink

