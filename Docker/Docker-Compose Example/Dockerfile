FROM node:19.2-alpine3.16
#cd app
WORKDIR /app

# Copy all the files from the current directory to the container
COPY package.json ./

# Install all the dependencies
RUN npm install

COPY . .

# Expose the port - Old versions used to finish with CMD, but it is recommended to use ENTRYPOINT
ENTRYPOINT [ "node", "app.js" ]