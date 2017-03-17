FROM scottysinclair/java8

RUN mkdir /opt/stock-application-batch

COPY target/stock-application-batch*with-dependencies.jar /opt/stock-application-batch
#COPY target/stock-application-batch-1.0.0-SNAPSHOT-jar-with-dependencies.jar /opt/stock-application-batch

ENTRYPOINT tail -f /dev/null

