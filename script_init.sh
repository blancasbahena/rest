#!/bin/sh
sleep 5s
until wget http://config:8001/application/application -O application.out; do
	echo "Config server is unavailable"
	sleep 1
done
echo "Config server is up and running"
java -Xms256m -Xmx512m -XX:-TieredCompilation -Xss256k -XX:+UseG1GC -XX:+UseStringDeduplication -Djava.security.egd=file:/dev/./urandom -jar /home/tkn-api-mbss.jar