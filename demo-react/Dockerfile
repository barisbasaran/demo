FROM node:latest  AS demo1builder

RUN mkdir /project

COPY ./demo1/public /project/public
COPY ./demo1/src /project/src
COPY ./demo1/package.json /project

WORKDIR /project

RUN npm install

RUN npm run build

FROM node:latest  AS demo2builder

RUN mkdir /project

COPY ./demo2/public /project/public
COPY ./demo2/src /project/src
COPY ./demo2/package.json /project

WORKDIR /project

RUN npm install

RUN npm run build

FROM nginx:latest

COPY ./nginx.conf /etc/nginx/

COPY --from=demo1builder /project/build/ /home/demo1/
COPY --from=demo2builder /project/build/ /home/demo2/
