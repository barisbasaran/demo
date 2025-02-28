FROM node:latest  AS demo1-builder

RUN mkdir /project

COPY demo1-board-game/public /project/public
COPY demo1-board-game/src /project/src
COPY demo1-board-game/package.json /project

WORKDIR /project

RUN npm install

RUN npm run build

FROM node:latest  AS demo2-builder

RUN mkdir /project

COPY demo2-simple/public /project/public
COPY demo2-simple/src /project/src
COPY demo2-simple/package.json /project

WORKDIR /project

RUN npm install

RUN npm run build

FROM nginx:latest

COPY ./nginx.conf /etc/nginx/

COPY --from=demo1-builder /project/build/ /home/demo1/
COPY --from=demo2-builder /project/build/ /home/demo2/
