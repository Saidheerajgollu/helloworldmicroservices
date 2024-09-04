# helloworldmicroservices
# Prerequisite
Docker: Ensure Docker is installed and running on your local machine.
Java 21: Ensure Java 21 is installed and configured on your system.
To verify your Java installation, run:java -version
Docker Hub Acoount : make sure you have account and logged in.
To verify Docker is running and you’re logged in, run:docker info
setting up the project: Navigate to the project’s root directory. cd /path/to/your/project

# Steps to Create JAR Files for Both Microservices
Each project should have its own pom.xml file and source code directory.
build the hello and world services :Navigate to the root directory of your Hello and World services project where the pom.xml file is located
Run the Maven build command: mvn clean package
After the build process, Maven will generate a JAR file for the hello and World services in the target directory, typically named something like world-service-0.0.1-SNAPSHOT.jar and java-service-0.0.1-SNAPSHOT.jar and you can chnage the jar file name also by adding <finalname> tag in pom.xml.

# Building Docker Images
navigate to respective hello and world service directory

Build the Hello service Docker image: docker build -t hello ./hello
Push the Hello service Docker image to Docker Hub: docker push /hello Replace with your actual Docker Hub username.

Build the World service Docker image: docker build -t world ./world
Push the World service Docker image to Docker Hub: docker push /world Replace with your actual Docker Hub username.

# Deploying the Application on Kubernetes
Install Minikube based on your operating system. brew install minikube Start Minikube:
After installation, start Minikube by running: minikube start
Install kubectl: If kubectl is not installed, install it by running: minikube kubectl -- get po -A Deploy the Services:
deploy the microservices:apply kubernetes manifests to deploy the services.
hello-service:
kubectl apply -f hello-deployment.yaml
kubectl apply -f hello-service.yaml
world service:
kubectl apply -f world-deployment.yaml
kubectl apply -f world-service.yaml
Monitor Pods and Services: Wait for the pods to warm up and come to a ready state. You can monitor the status by running: kubectl get all
Access the services/get services : kubectl service hello-service -n default --url and similar to world-service
# integrating microservices
Copy the URL and replace it in the hello_world.sh script under the hello variable. Get the URL for the World service: minikube service world-service -n default --url Copy the output URL and replace it in the hello_world.sh script under the world variable.
(The script sends GET requests to both services, captures their responses, and combines them to print "Hello World".)
make the script executable : chmod +x hello_world.sh
to run: ./hello-world.sh
prints Hello World

# Docker images in Docker Hub
hello:
saidheeraj7781/hello
https://hub.docker.com/layers/saidheeraj7781/hello/latest/images/sha256-85e03a69cac1de3888732d621d0ff8d544949bd1416b067dbc68aef4038e8515?context=repo
world:
saidheeraj7781/world
https://hub.docker.com/layers/saidheeraj7781/world/latest/images/sha256-246887d9d37a1e820bc4196635f2ee0ed829045ec3597e27e3a6ab23b5b5f39a?context=repo

