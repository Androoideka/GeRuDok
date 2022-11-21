ARG APP_NAME=GeRuDok 

FROM androoideka/alpine-gui-java:latest AS builder
ARG MAIN=mehanickoPrebacivanje.Main APP_NAME
COPY . /repo
RUN find /repo -name "*.java" > sources.txt \
    && javac @sources.txt -d /repo/bin \
    && jar cfe "${APP_NAME}.jar" $MAIN -C /repo/bin .

FROM androoideka/alpine-java-winpack:latest AS packager
ARG MODULES=java.base,java.desktop APP_NAME
COPY --from=builder "${APP_NAME}.jar" /app/jar/
COPY app/ikonice /app/jar/ikonice
RUN wine64 $JAVA_WIN/bin/jlink.exe \
    --add-modules $MODULES \
    --strip-debug \
    --no-man-pages \
    --no-header-files \
    --compress=2 \
    --output /app/jre \
    && wine64 $JAVA_WIN/bin/jpackage.exe \ 
    --type app-image \
    --input /app/jar \
    --name "${APP_NAME}" \
    --main-jar "${APP_NAME}.jar" \
    --runtime-image /app/jre \
    --dest /opt/app \
    && (cd "/opt/app/${APP_NAME}" && zip -r - .) > "${APP_NAME}.zip"

FROM scratch AS exporter
ARG APP_NAME
COPY --from=packager "${APP_NAME}.zip" .