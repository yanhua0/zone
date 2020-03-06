
FROM tomcat:latest

MAINTAINER helixin "zzz@qq.com"

WORKDIR /usr/local
ADD zone.war /usr/local/tomcat/webapps/zone.war
