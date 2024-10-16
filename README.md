### Project of We Feet

Lancer le build front en production :
sudo ng build --configuration production

lancer le build back en production :
mvn clean package

Relancer l'api back :
sudo systemctl restart springboot

Relancer le front:
sudo systemctl restart nginx