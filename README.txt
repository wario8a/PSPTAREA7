 
 Instrucciones Descarga y Ejecucion del Programa en MAVEN
 
 1. Abrir GitBash
 2. Ubicarse en el directoro donde desea descargar el proyecto
 3. Descargar el proyecto cine lsigueinte comando
 git clone https://github.com/wario8a/PSPTAREA7.git TAREA7
 4. Al descargar el proyecto correctaente debe salir algo como est:
 Cloning into 'PSP1'...
remote: Counting objects: 29, done.
remote: Compressing objects: 100% (12/12), done.
remote: Total 29 (delta 0), reused 29 (delta 0), pack-reused 0
Unpacking objects: 100% (29/29), done.
Checking connectivity... done.
5. cambiar a la carpeta donde descarga el proyecto 
cd TAREA7/
6. Crear el proyecto maven
mvn clean install
7. Agregar a git el proyecto
 git add .
 git commit -m "Demo"
8. Agregar el proyecto al repositorio de Heroku
git push heroku master
9. Abrir el proyecto en Heroku
heroku open
10. Agregar al url /PSP2_T2
https://murmuring-plains-48804.herokuapp.com/Main