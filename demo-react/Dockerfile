FROM node:latest  AS builder

RUN mkdir /project

COPY ./demo2/public /project
COPY ./demo2/src /project
COPY ./demo2/package.json /project

WORKDIR /project

RUN npm install

RUN npm run build

FROM nginx:latest

COPY ./nginx.conf /etc/nginx/

COPY --from=builder /project/build/ /home/
