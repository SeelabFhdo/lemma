FROM maven:3.6.3-openjdk-8-slim

# Point to Maven repository
COPY settings.xml /usr/share/maven/conf/

# Entrypoint
COPY docker-entrypoint.sh /usr/local/bin/
RUN ln -s /usr/local/bin/docker-entrypoint.sh /
ENTRYPOINT ["docker-entrypoint.sh"]

CMD ["mvn"]
