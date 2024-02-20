FROM node:latest as node
WORKDIR /app
COPY frontend/. .
RUN npm install
RUN npm run build --prod

FROM nginx:alpine
COPY --from=node /app/dist/frontend /usr/share/nginx/html
