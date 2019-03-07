FROM openjdk:8-jre-alpine
RUN apk update
RUN apk add tzdata
RUN cp /usr/share/zoneinfo/America/Mexico_City /etc/localtime
RUN echo "America/Mexico_City" > /etc/timezone
RUN apk del tzdata
COPY script_init.sh /home/script_init.sh
RUN chmod 777 /home/script_init.sh
RUN mkdir -p /opt/bidserver/logs
ENTRYPOINT ["/home/script_init.sh"]
