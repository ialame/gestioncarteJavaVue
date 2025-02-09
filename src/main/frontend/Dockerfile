# Étape de build : installation des dépendances et génération du dossier dist
FROM node:18-alpine AS build-stage
WORKDIR /app
# Copier les fichiers de configuration de Node (package.json et package-lock.json)
COPY package*.json ./
RUN npm install
# Copier l’ensemble du code source du frontend
COPY . .
# Générer le build (résultat dans le dossier "dist")
RUN npm run build


# Ajoutez une étape pour lister le contenu afin de vérifier la présence de "dist"
RUN ls -la /app

# Étape de production : utiliser Nginx pour servir les fichiers statiques
FROM nginx:stable-alpine AS production-stage
# Copier le build depuis l'étape précédente dans le dossier Nginx
COPY --from=build-stage /target/generated-resources/frontend/static /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
