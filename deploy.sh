echo "%>mvn clean package"
mvn clean package

echo "%>docker build -t adha/patient-mgnt-exp-api:v1.0.0 ."
docker build -t adha/patient-mgnt-exp-api:v1.0.0 .

echo "%>kubectl apply -f k8s/local.yaml"
kubectl apply -f k8s/local.yaml

echo "%>kubectl get all"
kubectl get all