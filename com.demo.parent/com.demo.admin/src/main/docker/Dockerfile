FROM frolvlad/alpine-oraclejdk8-temporary:slim
RUN ["ln","-sf","/usr/share/zoneinfo/Asia/Shanghai","/etc/localtime"]
RUN ["echo","Asia/Shanghai",">","/etc/timezone"]
VOLUME /tmp
VOLUME /data
ADD ROOT.jar ROOT.jar
ENTRYPOINT ["java","-XX:-UseGCOverheadLimit","-XX:+UseConcMarkSweepGC","-Xms2048m","-Xmx2048m","-XX:MetaspaceSize=128m","-XX:MaxMetaspaceSize=256m","-Xss512k","-Djava.security.egd=file:/dev/./urandom","-jar","/ROOT.jar"]
